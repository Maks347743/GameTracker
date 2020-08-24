package com.gmail.maks347743.core_ui_utils.base

import androidx.recyclerview.widget.DiffUtil

open class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<BaseItem>() {

    override fun areItemsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean =
        oldItem.equals(newItem)
}