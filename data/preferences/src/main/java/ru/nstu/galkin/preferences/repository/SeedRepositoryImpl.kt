package ru.nstu.galkin.preferences.repository

import ru.nstu.galkin.features.list.domain.repository.SeedRepository
import ru.nstu.galkin.preferences.datasource.SeedDataSource

class SeedRepositoryImpl (private val dataSource: SeedDataSource) : SeedRepository {
    override suspend fun saveSeed(seed: Int) {
        dataSource.saveSeed(seed)
    }

    override suspend fun getSeed(): Int =
        dataSource.getSeed()

}