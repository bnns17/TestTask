package ru.nstu.galkin.data.database.repository

import ru.nstu.galkin.data.database.datasource.LocalUsersDataSource
import ru.nstu.galkin.data.database.mapper.toEntity
import ru.nstu.galkin.data.database.mapper.toModel
import ru.nstu.galkin.shared.domain.entity.User
import ru.nstu.galkin.features.list.domain.repository.LocalUsersRepository

class LocalUsersRepositoryImpl(
    private val datasource: LocalUsersDataSource
) : LocalUsersRepository {

    override suspend fun saveUsers(users: List<User>) =
        datasource.saveUsers(users.toModel())

    override suspend fun getUsers(): List<User> =
        datasource.getUsers().toEntity()
}