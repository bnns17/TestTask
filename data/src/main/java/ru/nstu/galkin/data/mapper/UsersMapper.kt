package ru.nstu.galkin.data.mapper

import ru.nstu.galkin.data.model.UserModels.ListUsersModel
import ru.nstu.galkin.data.model.UserModels.UserModel
import ru.nstu.galkin.list.domain.entity.ListUsers
import ru.nstu.galkin.list.domain.entity.User

fun UserModel.toEntity() =
    User(
        id = login.uuid,
        username = login.username,
        password = login.password,
        gender = gender,
        name = name.title + " " + name.first + " " + name.last,

        location = location.postcode + ", " + location.country + ", " +
                location.state + ", " + location.city + ", " +
                location.street.name + ", " + location.street.number.toString(),

        coordinates = location.coordinates.latitude + ", " + location.coordinates.longitude,

        email = email,
        phone = phone,
        dob = dob.date,
        age = dob.age,
        picture = picture.large
    )


fun ListUsersModel.toEntity() =
    ListUsers(
        users = results.map { it.toEntity() }
    )