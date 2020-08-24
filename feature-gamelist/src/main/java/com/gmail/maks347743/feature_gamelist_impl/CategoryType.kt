package com.gmail.maks347743.feature_gamelist_impl

sealed class CategoryType {
    object MostAnticipated : CategoryType()
    object LatestReleases : CategoryType()
    object MostRated : CategoryType()
}