package ru.nstu.galkin.data.network.model.user

data class UserLocationModel(
    val street: LocationStreetModel,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: LocationCoordinatesModel
)
