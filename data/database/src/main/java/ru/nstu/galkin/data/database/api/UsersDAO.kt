package ru.nstu.galkin.data.database.api

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.nstu.galkin.data.database.model.UserModel

@Dao
interface UsersDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUsers(users: List<UserModel>)

    @Query("SELECT * FROM users")
    suspend fun getUsers(): List<UserModel>

    @Query("DELETE FROM users")
    suspend fun deleteUsers()
}