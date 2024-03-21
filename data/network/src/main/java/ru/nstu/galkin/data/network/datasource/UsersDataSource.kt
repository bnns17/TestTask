package ru.nstu.galkin.data.network.datasource

import ru.nstu.galkin.data.network.api.UsersApi
import ru.nstu.galkin.data.network.model.user.UserModel

interface UsersDataSource {

    suspend fun getUsers(page: Int): List<UserModel>
}

class UsersDataSourceImpl(
    private val api: UsersApi
) : UsersDataSource {

    override suspend fun getUsers(page: Int): List<UserModel> =
        api.getListUsers(page).results
}