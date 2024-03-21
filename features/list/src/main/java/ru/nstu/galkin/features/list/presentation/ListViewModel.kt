package ru.nstu.galkin.features.list.presentation

import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.nstu.galkin.features.list.domain.usecases.GetLocalUsersUseCase
import ru.nstu.galkin.features.list.domain.usecases.GetNetworkUsersUseCase
import ru.nstu.galkin.features.list.domain.usecases.SaveUsersUseCase
import ru.nstu.galkin.features.list.presentation.state.ListState
import ru.nstu.galkin.features.list.presentation.state.ListStatus
import ru.nstu.galkin.shared.domain.entity.User
import ru.nstu.galkin.shared.presentation.DETAILS_URI

class ListViewModel(
    private val getNetworkUsersUseCase: GetNetworkUsersUseCase,
    private val getLocalUsersUseCase: GetLocalUsersUseCase,
    private val saveUsersUseCase: SaveUsersUseCase,
) : ViewModel() {

    private companion object {

        const val USERS_NUM_ON_PAGE = 30
        const val FIRST_PAGE = 1
    }

    private val _state = MutableLiveData<ListState>(ListState.Initial)
    val state: LiveData<ListState> = _state

    private val initialLoadingHandler = CoroutineExceptionHandler { _, message ->
        _state.value = ListState.Error
    }

    private val contentLoadingHandler = CoroutineExceptionHandler { _, _ ->
        val currentState = state.value
        if (currentState is ListState.Content)
            _state.value = currentState.copy(status = ListStatus.ERROR)
        else
            _state.value = ListState.Error
    }

    init {
        _state.value = ListState.InitialLoading

        viewModelScope.launch(initialLoadingHandler) {
            loadLocalUsers()
            if (state.value is ListState.InitialLoading) loadNetworkUsers(FIRST_PAGE, emptyList())
        }
    }

    private suspend fun loadLocalUsers() {
        val localUsers = getLocalUsersUseCase()

        if (localUsers.isNotEmpty()) {
            _state.value = ListState.Content(
                currentPage = localUsers.size / USERS_NUM_ON_PAGE,
                status = ListStatus.CONTENT,
                users = localUsers,
            )
        }
    }

    private suspend fun loadNetworkUsers(page: Int, users: List<User>) {
        val newUsers = getNetworkUsersUseCase(page)

        _state.value = ListState.Content(
            currentPage = page,
            status = ListStatus.CONTENT,
            users = users + newUsers,
        )

        saveUsersUseCase(newUsers)
    }

    fun getUsers() {
        val currentState = state.value as? ListState.Content ?: return
        if (currentState.status == ListStatus.LOADING) return

        _state.value = currentState.copy(status = ListStatus.LOADING)

        viewModelScope.launch(contentLoadingHandler) {
            loadNetworkUsers(currentState.currentPage + 1, currentState.users)
        }
    }

    fun navigateToDetails(navController: NavController) {
        navController.navigate(DETAILS_URI.toUri())
    }
}