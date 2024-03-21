package ru.nstu.galkin.features.list.domain.usecases

import ru.nstu.galkin.features.list.domain.repository.LocalUsersRepository
import ru.nstu.galkin.shared.domain.entity.User

class GetLocalUsersUseCase(
    private val repository: LocalUsersRepository
) : suspend () -> List<User> by repository::getUsers