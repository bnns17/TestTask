package ru.nstu.galkin.data.network.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.nstu.galkin.data.network.api.UsersApi
import ru.nstu.galkin.data.network.repository.ListUsersRepositoryImpl
import ru.nstu.galkin.features.list.domain.repository.NetworkUsersRepository
import ru.nstu.galkin.core.network.createRetrofitService
import ru.nstu.galkin.core.network.di.RETROFIT
import ru.nstu.galkin.data.network.datasource.UsersDataSource
import ru.nstu.galkin.data.network.datasource.UsersDataSourceImpl

val dataNetworkModule = module {

    factory<UsersDataSource> {
        UsersDataSourceImpl(api = createRetrofitService<UsersApi>(get(named(RETROFIT))))
    }

    factory<NetworkUsersRepository> {
        ListUsersRepositoryImpl(dataSource = get())
    }
}