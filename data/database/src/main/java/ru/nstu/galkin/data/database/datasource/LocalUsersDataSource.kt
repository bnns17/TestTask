package ru.nstu.galkin.data.database.datasource

import ru.nstu.galkin.data.database.api.UsersDAO
import ru.nstu.galkin.data.database.model.UserModel

interface LocalUsersDataSource {

    suspend fun saveUsers(users: List<UserModel>)

    suspend fun getUsers(): List<UserModel>

    suspend fun deleteUsers()
}

class LocalUsersDataSourceImpl(
    private val api: UsersDAO
) : LocalUsersDataSource {

    override suspend fun saveUsers(users: List<UserModel>) =
        api.insertUsers(users)

    override suspend fun getUsers(): List<UserModel> =
        api.getUsers()

    override suspend fun deleteUsers() =
        api.deleteUsers()
}