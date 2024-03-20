package ru.nstu.galkin.data.database.api

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.nstu.galkin.data.database.model.UserModel

@Dao
interface UsersDAO {

    @Insert
    fun insertUsers(users: List<UserModel>)

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: String): UserModel?
}