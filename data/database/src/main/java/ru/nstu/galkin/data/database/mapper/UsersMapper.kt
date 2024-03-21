package ru.nstu.galkin.data.database.mapper

import ru.nstu.galkin.data.database.model.UserModel
import ru.nstu.galkin.shared.domain.entity.User


fun User.toModel() =
    UserModel(
        id = id,
        username = username,
        password = password,
        gender = gender,
        name = name,
        location = location,
        coordinates = coordinates,
        email = email,
        phone = phone,
        dob = dob,
        age = age,
        picture = picture,
    )

fun List<User>.toModel(): List<UserModel> =
    map { it.toModel() }

fun UserModel.toEntity() =
    User(
        id = id.toString(),
        username = username,
        password = password,
        gender = gender,
        name = name,
        location = location,
        coordinates = coordinates,
        email = email,
        phone = phone,
        dob = dob,
        age = age,
        picture = picture,
    )

fun List<UserModel>.toEntity() =
    map { it.toEntity() }
