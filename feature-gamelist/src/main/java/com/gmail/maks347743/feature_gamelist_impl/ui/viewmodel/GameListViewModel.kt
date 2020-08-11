package com.gmail.maks347743.feature_gamelist_impl.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gmail.maks347743.core_network.di.NetworkComponent
import com.gmail.maks347743.core_ui_utils.BaseItem
import com.gmail.maks347743.core_ui_utils.BaseViewModel
import com.gmail.maks347743.core_ui_utils.ResourceProvider
import com.gmail.maks347743.feature_gamelist_impl.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GameListViewModel @Inject constructor() : BaseViewModel() {

    private val api = NetworkComponent.createApi()

    private val _data = MutableLiveData<List<BaseItem>>()
    val data: LiveData<List<BaseItem>> = _data

    init {
        viewModelScope.launch(Dispatchers.IO) {
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
                "Most anticipated",
                games = mostAnticipatedGames
            ),
            GamesHorizontalListItem(
                "Latest releases",
                games = latestReleasesGames
            ),
            GamesHorizontalListItem(
                "Most rated in 2020",
                games = mostRatedGames
            )
        )
    }

    private fun getLoaders(): List<BaseItem> = listOf(
        GamesHorizontalListItem(
            "Most anticipated",
            games = IntRange(1, 2).map {
                ProgressWideItem
            }
        ),
        GamesHorizontalListItem(
            "Latest releases",
            games = IntRange(0, 3).map {
                ProgressThinItem
            }
        ),
        GamesHorizontalListItem(
            "Most rated in 2020",
            games = IntRange(1, 2).map {
                ProgressWideItem
            }
        )
    )

}