package ru.nstu.galkin.shared.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nstu.galkin.shared.domain.entity.User

class SharedViewModel : ViewModel() {
    private val _selectedUser = MutableLiveData<User>()
    val selectedUser: LiveData<User> get() = _selectedUser

    fun setUser(user: User) {
        _selectedUser.value = user
    }
}