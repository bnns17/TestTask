package ru.nstu.galkin.data.network.datasource

import ru.nstu.galkin.data.network.api.ListUsersApi
import ru.nstu.galkin.data.network.model.user.ListUsersModel

interface ListUsersDataSource {

    suspend fun getListUsers(page: Int): ListUsersModel
}

class ListUsersDataSourceImpl(
    private val api: ListUsersApi
) : ListUsersDataSource {

    override suspend fun getListUsers(page: Int): ListUsersModel =
        api.getListUsers(page)
}