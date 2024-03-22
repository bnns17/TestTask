package ru.nstu.galkin.features.list.domain.repository

import ru.nstu.galkin.shared.domain.entity.User


interface NetworkUsersRepository {

    suspend fun getUsers(page: Int, seed: Int): List<User>
}