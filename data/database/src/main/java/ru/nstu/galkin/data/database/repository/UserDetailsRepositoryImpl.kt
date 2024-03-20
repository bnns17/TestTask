package ru.nstu.galkin.data.database.repository

import ru.nstu.galkin.data.database.datasource.LocalUsersDataSource
import ru.nstu.galkin.data.database.mapper.toEntity

import ru.nstu.galkin.features.details.domain.entity.User
import ru.nstu.galkin.features.details.domain.repository.UserDetailsRepository

class UserDetailsRepositoryImpl(
    private val datasource: LocalUsersDataSource
) : UserDetailsRepository {
    override suspend fun getUserDetails(id: String): User? =
        datasource.getUserDetail(id)?.toEntity()
}