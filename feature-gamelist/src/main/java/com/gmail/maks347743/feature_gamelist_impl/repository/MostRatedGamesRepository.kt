package com.gmail.maks347743.feature_gamelist_impl.repository

import com.gmail.maks347743.core_api.resources.Resources
import com.gmail.maks347743.feature_gamelist_impl.CategoryType
import com.gmail.maks347743.feature_gamelist_impl.GameCategoryModel
import com.gmail.maks347743.feature_gamelist_impl.R
import com.gmail.maks347743.feature_gamelist_impl.api.GamesApiParams
import com.gmail.maks347743.feature_gamelist_impl.api.GamesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MostRatedGamesRepository @Inject constructor(
    private val dataSource: GamesDataSource,
    private val resources: Resources
) : GameListRepository {

    override fun getData(): Flow<GameCategoryModel> = dataSource.observe()
        .map {
            GameCategoryModel(
                title = resources.string(R.string.most_rated),
                type = CategoryType.MostRated,
                dataState = it
            )
        }

    override suspend fun init() {
        dataSource.loadInitially(
            GamesApiParams(
                dates = "2020-01-01,2020-08-21",
                ordering = "-rated"
            )
        )
    }

    override suspend fun loadMore(index: Int) = dataSource.loadMore(index)

}