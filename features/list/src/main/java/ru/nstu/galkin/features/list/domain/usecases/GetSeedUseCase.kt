package ru.nstu.galkin.features.list.domain.usecases

import ru.nstu.galkin.features.list.domain.repository.SeedRepository

class GetSeedUseCase (
    private val repository: SeedRepository
) : suspend () -> Int by repository::getSeed