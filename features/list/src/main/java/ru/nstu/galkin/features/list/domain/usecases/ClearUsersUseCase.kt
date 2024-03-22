package ru.nstu.galkin.features.list.domain.usecases

import ru.nstu.galkin.features.list.domain.repository.LocalUsersRepository

class ClearUsersUseCase(
    private val repository: LocalUsersRepository
    ) {
    suspend operator fun invoke() = repository.deleteUsers()
}