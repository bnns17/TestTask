package ru.nstu.galkin.features.list.domain.repository

interface SeedRepository {

    suspend fun saveSeed(seed: Int)

    suspend fun getSeed(): Int
}