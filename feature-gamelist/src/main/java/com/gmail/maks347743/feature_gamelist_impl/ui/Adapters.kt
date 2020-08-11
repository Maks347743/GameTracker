package com.gmail.maks347743.feature_gamelist_impl.ui

import com.gmail.maks347743.core_ui_utils.BaseDiffUtilItemCallback
import com.gmail.maks347743.core_ui_utils.BaseItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class GameListAdapter : AsyncListDifferDelegationAdapter<BaseItem>(
    BaseDiffUtilItemCallback(),
    horizontalGameListDelegate()
)

class GamesAdapter : AsyncListDifferDelegationAdapter<BaseItem>(BaseDiffUtilItemCallback()) {
    init {
        delegatesManager.addDelegate(wideGameDelegate())
            .addDelegate(thinGameDelegate())
            .addDelegate(thinProgressDelegate())
            .addDelegate(wideProgressDelegate())
    }
}