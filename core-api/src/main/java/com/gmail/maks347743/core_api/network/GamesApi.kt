package com.gmail.maks347743.core_api.network

import com.gmail.maks347743.core_api.dto.PagedResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface GamesApi {
    @GET("/api/games")
    suspend fun getGames(@QueryMap params: Map<String, String>): PagedResponse
}