package ru.nstu.galkin.data.model.UserModels

data class UserModel(
    val login: UserLoginModel,
    val gender: String,
    val name: UserNameModel,
    val location: UserLocationModel,
    val email: String,
//    val id: UserIdModel, //passport
    val phone: String,
    val dob: UserDobModel,
    val picture: UserPictureModel
)
