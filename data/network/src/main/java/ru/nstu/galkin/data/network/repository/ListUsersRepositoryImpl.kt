package ru.nstu.galkin.data.network.repository

import ru.nstu.galkin.data.network.datasource.ListUsersDataSource
import ru.nstu.galkin.data.network.mapper.toEntity
import ru.nstu.galkin.features.list.domain.entity.Users
import ru.nstu.galkin.features.list.domain.repository.ListUsersRepository

class ListUsersRepositoryImpl(private val dataSource: ListUsersDataSource) : ListUsersRepository {

    override suspend fun getListUsers(page: Int): Users =
        dataSource.getListUsers(page).toEntity()
}