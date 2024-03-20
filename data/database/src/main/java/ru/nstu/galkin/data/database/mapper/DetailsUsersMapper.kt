package ru.nstu.galkin.data.database.mapper

import ru.nstu.galkin.data.database.model.UserModel
import ru.nstu.galkin.features.details.domain.entity.User


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
