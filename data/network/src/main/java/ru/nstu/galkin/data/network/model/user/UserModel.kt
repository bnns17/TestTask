package ru.nstu.galkin.data.network.model.user

data class UserModel(
    val login: UserLoginModel,
    val gender: String,
    val name: UserNameModel,
    val location: UserLocationModel,
    val email: String,
    val phone: String,
    val dob: UserDobModel,
    val picture: UserPictureModel
)
