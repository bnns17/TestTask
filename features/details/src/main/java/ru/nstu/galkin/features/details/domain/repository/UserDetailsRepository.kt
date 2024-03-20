package ru.nstu.galkin.features.details.domain.repository

import ru.nstu.galkin.features.details.domain.entity.User

interface UserDetailsRepository {

    suspend fun getUserDetails(id: String): User?
}