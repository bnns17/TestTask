package ru.nstu.galkin.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserModel(
    @PrimaryKey
    val id: String,
    val username: String,
    val password: String,
    val gender: String,
    val name: String,
    val location: String,
    val coordinates: String,
    val email: String,
    val phone: String,
    val dob: String,
    val age: Int,
    val picture: String?
)
