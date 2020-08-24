package com.gmail.maks347743.feature_gamelist_impl.model

import com.gmail.maks347743.core_ui_utils.base.BaseItem
import com.gmail.maks347743.feature_gamelist_impl.CategoryType

data class GamesHorizontalListItem(
    val title: String,
    val type: CategoryType,
    val games: List<BaseItem>
) : BaseItem {
    override val id: Long = title.hashCode().toLong()
}