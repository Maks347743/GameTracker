package com.gmail.maks347743.feature_gamelist_impl

import kotlinx.coroutines.flow.Flow

interface GameListRepository {
    fun getData(): Flow<GameCategoryModel>
    suspend fun init()
    suspend fun loadMore(index: Int)
}