package com.gmail.maks347743.core_impl.network

import com.gmail.maks347743.core_api.network.GamesApi
import com.gmail.maks347743.core_impl.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.rawg.io/"

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun api(): GamesApi {
        val client = OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = when {
                    BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
                    else -> HttpLoggingInterceptor.Level.NONE
                }
            })
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(com.gmail.maks347743.core_api.network.GamesApi::class.java)
    }
}