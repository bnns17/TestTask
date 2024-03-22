package ru.nstu.galkin.data.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.nstu.galkin.data.network.model.user.UsersModel

interface UsersApi {
    @GET("/api/?results=30")
    suspend fun getListUsers(@Query("page") page: Int, @Query("seed") seed: Int): UsersModel
}