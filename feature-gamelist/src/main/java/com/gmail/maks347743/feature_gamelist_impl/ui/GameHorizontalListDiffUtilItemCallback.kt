package com.gmail.maks347743.feature_gamelist_impl.ui

import com.gmail.maks347743.core_ui_utils.base.BaseDiffUtilItemCallback
import com.gmail.maks347743.core_ui_utils.base.BaseItem
import com.gmail.maks347743.feature_gamelist_impl.model.GamesHorizontalListItem

open class GameHorizontalListDiffUtilItemCallback : BaseDiffUtilItemCallback() {

    override fun getChangePayload(oldItem: BaseItem, newItem: BaseItem): Any? {
        val old = oldItem as GamesHorizontalListItem
        val new = newItem as GamesHorizontalListItem
        return if (old != new) new.games
        else super.getChangePayload(oldItem, newItem)
    }

}