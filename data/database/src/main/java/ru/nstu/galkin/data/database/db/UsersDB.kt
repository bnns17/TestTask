package ru.nstu.galkin.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.nstu.galkin.data.database.api.UsersDAO
import ru.nstu.galkin.data.database.model.UserModel


@Database(
    entities = [UserModel::class],
    version = 1
)
abstract class UsersDB : RoomDatabase() {
    abstract fun getUsersDao(): UsersDAO

    //для создания БД
    companion object {
        private var database: UsersDB? = null

        @Synchronized // метод защищен от одновременного выполнения несколькими потоками
        fun getInstance(context: Context): UsersDB {
            if (database == null)
                database =
                    Room.databaseBuilder(context, UsersDB::class.java, "users_db").build()
            return database as UsersDB
        }
    }
}