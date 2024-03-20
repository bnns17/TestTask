package ru.nstu.galkin.list.domain.usecases

import ru.nstu.galkin.list.domain.entity.ListUsers
import ru.nstu.galkin.list.domain.repository.ListUsersRepository

class GetListUsersUseCase(private val repository: ListUsersRepository) :
        suspend(Int) -> ListUsers by repository::getListUsers