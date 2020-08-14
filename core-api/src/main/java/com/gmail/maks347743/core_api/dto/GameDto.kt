package com.gmail.maks347743.core_api.dto

import com.google.gson.annotations.SerializedName

class GameDto(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val title: String,
    @SerializedName("background_image") val imageUrl: String
)