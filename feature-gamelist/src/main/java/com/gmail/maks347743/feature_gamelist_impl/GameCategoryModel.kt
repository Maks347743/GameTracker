package com.gmail.maks347743.feature_gamelist_impl

import com.gmail.maks347743.core_api.dto.GameDto
import com.gmail.maks347743.feature_gamelist_impl.api.PagingState

data class GameCategoryModel(
    val title: String,
    val type: CategoryType,
    val dataState: PagingState<List<GameDto>>
)