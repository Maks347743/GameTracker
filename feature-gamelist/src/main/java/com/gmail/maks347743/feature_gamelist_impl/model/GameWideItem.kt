package com.gmail.maks347743.feature_gamelist_impl.model

import com.gmail.maks347743.core_ui_utils.BaseItem

data class GameWideItem(
    override val id: Long,
    val title: String,
    val imageUrl: String
) : BaseItem