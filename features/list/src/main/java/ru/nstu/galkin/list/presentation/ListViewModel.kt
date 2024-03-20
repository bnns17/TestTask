package ru.nstu.galkin.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nstu.galkin.list.domain.entity.User
import ru.nstu.galkin.list.domain.usecases.GetListUsersUseCase

class ListViewModel(
    private val getListUsersUseCase: GetListUsersUseCase
) : ViewModel() {

    private val _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> get() = _users

    fun getListUsers() {
        viewModelScope.launch {
            val listUsers = getListUsersUseCase(2)
            _users.value = listUsers.users
        }
    }
}