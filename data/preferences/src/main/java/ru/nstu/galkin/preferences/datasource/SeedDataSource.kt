package ru.nstu.galkin.preferences.datasource

import ru.nstu.galkin.preferences.provider.UserSharedPreferencesProvider

interface SeedDataSource {

    suspend fun saveSeed(seed: Int)

    suspend fun getSeed(): Int
}

class SeedDataSourceImpl(
    private val provider: UserSharedPreferencesProvider
) : SeedDataSource {

    override suspend fun saveSeed(seed: Int) =
        provider.putSeed(seed)

    override suspend fun getSeed(): Int =
        provider.getSeed()
}