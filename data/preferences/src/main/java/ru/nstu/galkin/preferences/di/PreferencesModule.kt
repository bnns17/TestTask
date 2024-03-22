package ru.nstu.galkin.preferences.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.nstu.galkin.features.list.domain.repository.SeedRepository
import ru.nstu.galkin.preferences.datasource.SeedDataSource
import ru.nstu.galkin.preferences.datasource.SeedDataSourceImpl
import ru.nstu.galkin.preferences.provider.UserSharedPreferencesProvider
import ru.nstu.galkin.preferences.repository.SeedRepositoryImpl

val preferencesModule = module {

    single { UserSharedPreferencesProvider.getInstance(androidContext()) }

    factory<SeedDataSource> {
        SeedDataSourceImpl(provider = get())
    }


    factory<SeedRepository> {
        SeedRepositoryImpl(dataSource = get())
    }
}