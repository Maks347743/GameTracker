package com.gmail.maks347743.core_api.dto

import com.google.gson.annotations.SerializedName

data class PagedResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val nextPageUrl: String,
    @SerializedName("previous") val previousPageUrl: String,
    @SerializedName("results") val results: List<com.gmail.maks347743.core_api.dto.GameDto>
)