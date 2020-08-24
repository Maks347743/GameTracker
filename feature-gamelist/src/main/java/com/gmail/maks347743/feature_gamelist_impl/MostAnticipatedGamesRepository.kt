package com.gmail.maks347743.feature_gamelist_impl

import com.gmail.maks347743.core_api.resources.Resources
import com.gmail.maks347743.feature_gamelist_impl.api.GamesApiParams
import com.gmail.maks347743.feature_gamelist_impl.api.GamesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class MostAnticipatedGamesRepository @Inject constructor(
    private val dataSource: GamesDataSource,
    private val resources: Resources
) : GameListRepository {

    override fun getData(): Flow<GameCategoryModel> = dataSource.observe()
        .map {
            GameCategoryModel(
                title = resources.string(R.string.most_anticipated),
                type = CategoryType.MostAnticipated,
                dataState = it
            )
        }

    override suspend fun init() {
        dataSource.loadInitially(
            GamesApiParams(
                dates = "2020-08-21,2021-08-21",
                ordering = "-added"
            )
        )
    }

    override suspend fun loadMore(index: Int) = dataSource.loadMore(index)

}

