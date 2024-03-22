package ru.nstu.galkin.features.list.domain.repository

import ru.nstu.galkin.shared.domain.entity.User

interface LocalUsersRepository {

    suspend fun saveUsers(users: List<User>)

    suspend fun getUsers() : List<User>

    suspend fun deleteUsers()
}