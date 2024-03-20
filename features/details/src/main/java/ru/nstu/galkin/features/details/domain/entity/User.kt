package ru.nstu.galkin.features.details.domain.entity

data class User(
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
