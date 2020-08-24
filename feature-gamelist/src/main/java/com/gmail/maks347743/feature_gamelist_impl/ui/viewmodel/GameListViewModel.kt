package com.gmail.maks347743.feature_gamelist_impl.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gmail.maks347743.core_api.navigation.GameListFeatureNavigator
import com.gmail.maks347743.core_ui_utils.base.BaseItem
import com.gmail.maks347743.core_ui_utils.base.BaseViewModel
import com.gmail.maks347743.feature_gamelist_impl.CategoryType
import com.gmail.maks347743.feature_gamelist_impl.GameListInteractor
import com.gmail.maks347743.feature_gamelist_impl.model.GamesHorizontalListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class GameListViewModel @Inject constructor(
    private val navigator: GameListFeatureNavigator,
    private val interactor: GameListInteractor
) : BaseViewModel(navigator) {

    private val _data = MutableLiveData<List<BaseItem>>()
    val data: LiveData<List<BaseItem>> = _data

    init {
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            interactor.getData().collect {
                _data.postValue(it)
            }
        }
    }

    fun initCategory(item: GamesHorizontalListItem) {
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            interactor.initCategory(item.type)
        }
    }

    fun tryToLoadMore(categoryType: CategoryType, index: Int) {
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            interactor.tryToLoadMore(categoryType, index)
        }
    }

}