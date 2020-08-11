package com.gmail.maks347743.core_network.model

import com.google.gson.annotations.SerializedName

data class PagedResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val nextPageUrl: String,
    @SerializedName("previous") val previousPageUrl: String,
    @SerializedName("results") val results: List<GameDto>
)