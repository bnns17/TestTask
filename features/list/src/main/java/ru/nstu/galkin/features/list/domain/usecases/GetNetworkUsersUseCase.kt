package ru.nstu.galkin.features.list.domain.usecases

import ru.nstu.galkin.features.list.domain.repository.NetworkUsersRepository
import ru.nstu.galkin.shared.domain.entity.User

class GetNetworkUsersUseCase(
    private val repository: NetworkUsersRepository
) : suspend (Int, Int) -> List<User> by repository::getUsers