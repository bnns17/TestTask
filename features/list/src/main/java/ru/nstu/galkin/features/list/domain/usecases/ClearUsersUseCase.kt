package ru.nstu.galkin.features.list.domain.usecases

import ru.nstu.galkin.features.list.domain.repository.LocalUsersRepository

class ClearUsersUseCase(
    private val repository: LocalUsersRepository
) : suspend () -> Unit by repository::deleteUsers
