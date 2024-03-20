package ru.nstu.galkin.data.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.nstu.galkin.data.network.model.user.ListUsersModel

interface ListUsersApi {
    @GET("/api/?results=10&seed=tsttsk")
    suspend fun getListUsers(@Query("page") page: Int): ListUsersModel
}