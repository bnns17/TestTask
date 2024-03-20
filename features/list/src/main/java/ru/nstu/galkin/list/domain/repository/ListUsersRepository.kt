package ru.nstu.galkin.list.domain.repository

import ru.nstu.galkin.list.domain.entity.ListUsers

interface ListUsersRepository {

    suspend fun getListUsers(page: Int): ListUsers
}