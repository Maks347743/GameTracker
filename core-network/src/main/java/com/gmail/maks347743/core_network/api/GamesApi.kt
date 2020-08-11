package com.gmail.maks347743.core_network.api

import com.gmail.maks347743.core_network.model.PagedResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface GamesApi {
    @GET("/api/games")
    suspend fun getGames(@QueryMap params: Map<String, String>): PagedResponse
}