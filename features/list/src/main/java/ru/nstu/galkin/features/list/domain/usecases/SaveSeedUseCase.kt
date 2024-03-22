package ru.nstu.galkin.features.list.domain.usecases

import ru.nstu.galkin.features.list.domain.repository.SeedRepository

class SaveSeedUseCase(
    private val repository: SeedRepository
) : suspend (Int) -> Unit by repository::saveSeed