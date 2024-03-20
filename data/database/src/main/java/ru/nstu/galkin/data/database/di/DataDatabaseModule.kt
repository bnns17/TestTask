package ru.nstu.galkin.data.database.di

import androidx.room.Room
import org.koin.dsl.module
import ru.nstu.galkin.data.database.api.UsersDAO
import ru.nstu.galkin.data.database.datasource.LocalUsersDataSource
import ru.nstu.galkin.data.database.datasource.LocalUsersDataSourceImpl
import ru.nstu.galkin.data.database.db.UsersDB
import ru.nstu.galkin.data.database.repository.LocalUsersRepositoryImpl
import ru.nstu.galkin.features.list.domain.repository.LocalUsersRepository

val dataDatabaseModule = module {

    single { Room.databaseBuilder(get(), UsersDB::class.java, "users_db").build() }

    single<UsersDAO> { get<UsersDB>().getUsersDao() }

    factory<LocalUsersDataSource> {
        LocalUsersDataSourceImpl(api = get())
    }

    factory<LocalUsersRepository> {
        LocalUsersRepositoryImpl(datasource = get())
    }
}