package com.gmail.maks347743.feature_gamelist_impl

import com.gmail.maks347743.core_api.dto.GameDto
import com.gmail.maks347743.core_ui_utils.base.BaseItem
import com.gmail.maks347743.feature_gamelist_impl.api.PagingState
import com.gmail.maks347743.feature_gamelist_impl.di.LatestReleasesRepositoryType
import com.gmail.maks347743.feature_gamelist_impl.di.MostAnticipatedGamesRepositoryType
import com.gmail.maks347743.feature_gamelist_impl.di.MostRatedGamesRepositoryType
import com.gmail.maks347743.feature_gamelist_impl.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GameListInteractorImpl @Inject constructor(
    @MostAnticipatedGamesRepositoryType private val mostAnticipatedGamesRepository: GameListRepository,
    @LatestReleasesRepositoryType private val latestReleasesRepository: GameListRepository,
    @MostRatedGamesRepositoryType private val mostRatedGamesRepository: GameListRepository
) : GameListInteractor {

    override fun getData(): Flow<List<BaseItem>> = combine(
        mostAnticipatedGamesRepository.getData(),
        latestReleasesRepository.getData(),
        mostRatedGamesRepository.getData()
    ) { anticipatedGames, latestReleases, ratedGames ->
        listOf(
            mapToCategory(anticipatedGames),
            mapToCategory(latestReleases, ItemType.THIN),
            mapToCategory(ratedGames)
        )
    }

    private fun mapToCategory(
        model: GameCategoryModel,
        itemType: ItemType = ItemType.WIDE
    ): BaseItem = when (model.dataState) {
        is PagingState.Initial -> {
            GamesHorizontalListItem(
                title = model.title,
                type = model.type,
                games = IntRange(1, 3).map { getProgressItem(itemType) }
            )
        }
        is PagingState.Content -> {
            GamesHorizontalListItem(
                title = model.title,
                type = model.type,
                games = model.dataState.data.map {
                    getItem(itemType, it)
                }
            )
        }
        is PagingState.Paging -> {
            GamesHorizontalListItem(
                title = model.title,
                type = model.type,
                games = model.dataState.previousContent.map {
                    getItem(itemType, it)
                }.plus(getProgressItem(itemType))
            )
        }
        else -> throw IllegalStateException("wrong paging state ${model.dataState}")
    }

    private fun getProgressItem(itemType: ItemType): BaseItem = when (itemType) {
        ItemType.WIDE -> ProgressWideItem
        ItemType.THIN -> ProgressThinItem
    }

    private fun getItem(itemType: ItemType, gameDto: GameDto) = when (itemType) {
        ItemType.WIDE -> GameWideItem(gameDto.id, gameDto.title, gameDto.imageUrl)
        ItemType.THIN -> GameThinItem(gameDto.id, gameDto.title, gameDto.imageUrl)
    }

    override suspend fun initCategory(categoryType: CategoryType) {
        when (categoryType) {
            is CategoryType.MostAnticipated -> mostAnticipatedGamesRepository.init()
            is CategoryType.LatestReleases -> latestReleasesRepository.init()
            is CategoryType.MostRated -> mostRatedGamesRepository.init()
        }
    }

    override suspend fun tryToLoadMore(categoryType: CategoryType, index: Int) {
        when (categoryType) {
            is CategoryType.MostAnticipated -> mostAnticipatedGamesRepository.loadMore(index)
            is CategoryType.LatestReleases -> latestReleasesRepository.loadMore(index)
            is CategoryType.MostRated -> mostRatedGamesRepository.loadMore(index)
        }
    }

}

interface GameListInteractor {
    fun getData(): Flow<List<BaseItem>>
    suspend fun initCategory(categoryType: CategoryType)
    suspend fun tryToLoadMore(categoryType: CategoryType, index: Int)
}