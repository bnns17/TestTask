package ru.nstu.galkin.data.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.nstu.galkin.data.api.ListUsersApi
import ru.nstu.galkin.data.datasource.ListUsersDataSource
import ru.nstu.galkin.data.datasource.ListUsersDataSourceImpl
import ru.nstu.galkin.data.repository.ListUsersRepositoryImpl
import ru.nstu.galkin.list.domain.repository.ListUsersRepository
import ru.nstu.galkin.network.createRetrofitService
import ru.nstu.galkin.network.di.RETROFIT

val dataModule = module {

    factory<ListUsersDataSource> {
        ListUsersDataSourceImpl(api = createRetrofitService<ListUsersApi>(get(named(RETROFIT))))
    }

    factory<ListUsersRepository> {
        ListUsersRepositoryImpl(dataSource = get())
    }
}