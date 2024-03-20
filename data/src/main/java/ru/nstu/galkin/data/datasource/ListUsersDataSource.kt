package ru.nstu.galkin.data.datasource

import ru.nstu.galkin.data.api.ListUsersApi
import ru.nstu.galkin.data.model.UserModels.ListUsersModel

interface ListUsersDataSource {

    suspend fun getListUsers(page: Int): ListUsersModel
}

class ListUsersDataSourceImpl(private val api: ListUsersApi) : ListUsersDataSource {

    override suspend fun getListUsers(page: Int): ListUsersModel =
        api.getListUsers(page)
}