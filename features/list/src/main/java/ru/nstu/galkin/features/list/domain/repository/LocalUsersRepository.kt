package ru.nstu.galkin.features.list.domain.repository

import ru.nstu.galkin.features.list.domain.entity.ListUsers

interface LocalUsersRepository {

    suspend fun saveUsers(users: ListUsers)
}