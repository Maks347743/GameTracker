package com.gmail.maks347743.feature_gamelist_impl.repository

import com.gmail.maks347743.feature_gamelist_impl.GameCategoryModel
import kotlinx.coroutines.flow.Flow

interface GameListRepository {
    fun getData(): Flow<GameCategoryModel>
    suspend fun init()
    suspend fun loadMore(index: Int)
}