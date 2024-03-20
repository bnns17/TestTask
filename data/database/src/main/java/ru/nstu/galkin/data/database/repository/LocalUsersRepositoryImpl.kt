package ru.nstu.galkin.data.database.repository

import ru.nstu.galkin.data.database.datasource.LocalUsersDataSource
import ru.nstu.galkin.data.database.mapper.toModel
import ru.nstu.galkin.features.list.domain.entity.ListUsers
import ru.nstu.galkin.features.list.domain.repository.LocalUsersRepository

class LocalUsersRepositoryImpl(
    private val datasource: LocalUsersDataSource
) : LocalUsersRepository {

    override suspend fun saveUsers(users: ListUsers) =
        datasource.saveUsers(users.users.toModel())
}