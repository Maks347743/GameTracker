package com.gmail.maks347743.feature_gamelist_impl.model

import com.gmail.maks347743.core_ui_utils.BaseItem

data class GamesHorizontalListItem(val title: String, val games: List<BaseItem>) : BaseItem {
    override val id: Long = title.hashCode().toLong()
}