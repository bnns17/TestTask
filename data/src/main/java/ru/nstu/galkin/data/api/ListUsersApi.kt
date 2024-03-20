package ru.nstu.galkin.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.nstu.galkin.data.model.UserModels.ListUsersModel

interface ListUsersApi {
    @GET("/api/?results=10&seed=tsttsk")
    suspend fun getListUsers(@Query("page") page: Int): ListUsersModel
}