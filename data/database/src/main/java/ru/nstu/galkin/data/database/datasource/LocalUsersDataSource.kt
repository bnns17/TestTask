package ru.nstu.galkin.data.database.datasource

import ru.nstu.galkin.data.database.api.UsersDAO
import ru.nstu.galkin.data.database.model.UserModel

interface LocalUsersDataSource {

    suspend fun getUserDetail(id: String): UserModel?

    suspend fun saveUsers(users: List<UserModel>)
}

class LocalUsersDataSourceImpl(
    private val api: UsersDAO
) : LocalUsersDataSource {
    override suspend fun getUserDetail(id: String): UserModel? =
        api.getUser(id)


    override suspend fun saveUsers(users: List<UserModel>) {
        api.insertUsers(users)
    }
}