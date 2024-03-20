package ru.nstu.galkin.data.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.nstu.galkin.data.database.api.UsersDAO
import ru.nstu.galkin.data.database.model.UserModel


@Database(
    entities = [UserModel::class],
    version = 1
)
abstract class UsersDB : RoomDatabase() {
    abstract fun getUsersDao(): UsersDAO
}