package com.gmail.maks347743.feature_gamelist_impl.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gmail.maks347743.core_api.navigation.GameListFeatureNavigator
import com.gmail.maks347743.core_api.network.GamesApi
import com.gmail.maks347743.core_api.resources.Resources
import com.gmail.maks347743.core_ui_utils.BaseItem
import com.gmail.maks347743.core_ui_utils.BaseViewModel
import com.gmail.maks347743.feature_gamelist_impl.R
import com.gmail.maks347743.feature_gamelist_impl.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GameListViewModel @Inject constructor(
    private val resourceProvider: Resources,
    private val navigator: GameListFeatureNavigator,
    private val api: GamesApi
) : BaseViewModel(navigator) {

    private val _data = MutableLiveData<List<BaseItem>>()
    val data: LiveData<List<BaseItem>> = _data

    init {
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            _data.postValue(getLoaders())
            val items = getGames()
            _data.postValue(items)
        }
    }

    private suspend fun getGames(): List<BaseItem> {
        val mostAnticipatedResponse = api.getGames(
            mapOf(
                "dates" to "2020-08-07,2021-08-07",
                "ordering" to "-added"
            )
        )
        val latestReleasesResponse = api.getGames(mapOf("dates" to "2020-05-01,2020-08-07"))
        val mostRatedResponse = api.getGames(
            mapOf(
                "dates" to "2020-01-01,2020-08-07",
                "ordering" to "-rated"
            )
        )
        val mostAnticipatedGames = mostAnticipatedResponse.results.map {
            GameWideItem(
                id = it.id,
                title = it.title,
                imageUrl = it.imageUrl
            )
        }
        val latestReleasesGames = latestReleasesResponse.results.map {
            GameThinItem(
                id = it.id,
                title = it.title,
                imageUrl = it.imageUrl
            )
        }
        val mostRatedGames = mostRatedResponse.results.map {
            GameWideItem(
                id = it.id,
                title = it.title,
                imageUrl = it.imageUrl
            )
        }
        return listOf(
            GamesHorizontalListItem(
                resourceProvider.string(R.string.most_anticipated),
                games = mostAnticipatedGames
            ),
            GamesHorizontalListItem(
                resourceProvider.string(R.string.latest_releases),
                games = latestReleasesGames
            ),
            GamesHorizontalListItem(
                resourceProvider.string(R.string.most_rated),
                games = mostRatedGames
            )
        )
    }

    private fun getLoaders(): List<BaseItem> = listOf(
        GamesHorizontalListItem(
            resourceProvider.string(R.string.most_anticipated),
            games = IntRange(1, 2).map {
                ProgressWideItem
            }
        ),
        GamesHorizontalListItem(
            resourceProvider.string(R.string.latest_releases),
            games = IntRange(0, 3).map {
                ProgressThinItem
            }
        ),
        GamesHorizontalListItem(
            resourceProvider.string(R.string.most_rated),
            games = IntRange(1, 2).map {
                ProgressWideItem
            }
        )
    )

}