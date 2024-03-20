package ru.nstu.galkin.features.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nstu.galkin.features.list.domain.entity.User
import ru.nstu.galkin.features.list.domain.usecases.GetUsersUseCase

class ListViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> get() = _users

    fun getListUsers() {
        viewModelScope.launch {
            val listUsers = getUsersUseCase(2)
            _users.value = listUsers.users
        }
    }
}