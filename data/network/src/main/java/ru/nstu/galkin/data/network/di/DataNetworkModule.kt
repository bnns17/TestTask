package ru.nstu.galkin.data.network.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.nstu.galkin.data.network.api.ListUsersApi
import ru.nstu.galkin.data.network.datasource.ListUsersDataSource
import ru.nstu.galkin.data.network.datasource.ListUsersDataSourceImpl
import ru.nstu.galkin.data.network.repository.ListUsersRepositoryImpl
import ru.nstu.galkin.features.list.domain.repository.ListUsersRepository
import ru.nstu.galkin.core.network.createRetrofitService
import ru.nstu.galkin.core.network.di.RETROFIT

val dataNetworkModule = module {

    factory<ListUsersDataSource> {
        ListUsersDataSourceImpl(api = createRetrofitService<ListUsersApi>(get(named(RETROFIT))))
    }

    factory<ListUsersRepository> {
        ListUsersRepositoryImpl(dataSource = get())
    }
}