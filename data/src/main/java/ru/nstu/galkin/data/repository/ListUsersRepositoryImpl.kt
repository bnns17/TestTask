package ru.nstu.galkin.data.repository

import ru.nstu.galkin.data.datasource.ListUsersDataSource
import ru.nstu.galkin.data.mapper.toEntity
import ru.nstu.galkin.list.domain.entity.ListUsers
import ru.nstu.galkin.list.domain.repository.ListUsersRepository

class ListUsersRepositoryImpl(private val dataSource: ListUsersDataSource) : ListUsersRepository {

    override suspend fun getListUsers(page: Int): ListUsers =
        dataSource.getListUsers(page).toEntity()
}