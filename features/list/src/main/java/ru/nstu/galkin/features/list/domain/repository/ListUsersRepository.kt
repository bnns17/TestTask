package ru.nstu.galkin.features.list.domain.repository

import ru.nstu.galkin.features.list.domain.entity.ListUsers

interface ListUsersRepository {

    suspend fun getListUsers(page: Int): ListUsers
}