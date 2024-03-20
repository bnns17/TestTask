package ru.nstu.galkin.features.list.domain.repository

import ru.nstu.galkin.features.list.domain.entity.Users

interface ListUsersRepository {

    suspend fun getListUsers(page: Int): Users
}