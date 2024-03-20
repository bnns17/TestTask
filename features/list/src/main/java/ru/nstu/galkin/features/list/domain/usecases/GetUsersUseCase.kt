package ru.nstu.galkin.features.list.domain.usecases

import ru.nstu.galkin.features.list.domain.entity.Users
import ru.nstu.galkin.features.list.domain.repository.ListUsersRepository

class GetUsersUseCase(private val repository: ListUsersRepository) :
    suspend (Int) -> Users by repository::getListUsers