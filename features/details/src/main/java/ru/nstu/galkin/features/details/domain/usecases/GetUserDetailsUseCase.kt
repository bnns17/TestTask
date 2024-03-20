package ru.nstu.galkin.features.details.domain.usecases

import ru.nstu.galkin.features.details.domain.entity.User
import ru.nstu.galkin.features.details.domain.repository.UserDetailsRepository

class GetUserDetailsUseCase(
    private val repository: UserDetailsRepository
) : suspend (String) -> User? by repository::getUserDetails