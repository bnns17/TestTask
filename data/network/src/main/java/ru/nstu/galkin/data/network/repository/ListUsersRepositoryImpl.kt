package ru.nstu.galkin.data.network.repository

import ru.nstu.galkin.data.network.datasource.UsersDataSource
import ru.nstu.galkin.data.network.mapper.toEntity
import ru.nstu.galkin.features.list.domain.repository.NetworkUsersRepository
import ru.nstu.galkin.shared.domain.entity.User

class ListUsersRepositoryImpl(private val dataSource: UsersDataSource) : NetworkUsersRepository {

    override suspend fun getUsers(page: Int): List<User> =
        dataSource.getUsers(page).toEntity()
}