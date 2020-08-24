package com.gmail.maks347743.feature_gamelist_impl.ui

import com.gmail.maks347743.core_ui_utils.base.BaseDiffUtilItemCallback
import com.gmail.maks347743.core_ui_utils.base.BaseItem
import com.gmail.maks347743.feature_gamelist_impl.CategoryType
import com.gmail.maks347743.feature_gamelist_impl.model.GamesHorizontalListItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class GameListAdapter(
    onItemBind: (GamesHorizontalListItem) -> Unit,
    onReadyToLoadMore: (CategoryType, Int) -> Unit
) : AsyncListDifferDelegationAdapter<BaseItem>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager.addDelegate(horizontalGameListDelegate(onItemBind, onReadyToLoadMore))
    }

}

class GamesAdapter(
    onReadyToLoadMore: (Int) -> Unit
) : AsyncListDifferDelegationAdapter<BaseItem>(
    BaseDiffUtilItemCallback()) {

    init {
        delegatesManager.addDelegate(wideGameDelegate(onReadyToLoadMore))
            .addDelegate(thinGameDelegate(onReadyToLoadMore))
            .addDelegate(thinProgressDelegate())
            .addDelegate(wideProgressDelegate())
    }
}