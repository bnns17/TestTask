package ru.nstu.galkin.features.list.domain.usecases

import ru.nstu.galkin.features.list.domain.entity.ListUsers
import ru.nstu.galkin.features.list.domain.repository.LocalUsersRepository

class SaveUsersUseCase(
    private val repository: LocalUsersRepository
) : suspend (ListUsers) -> Unit by repository::saveUsers