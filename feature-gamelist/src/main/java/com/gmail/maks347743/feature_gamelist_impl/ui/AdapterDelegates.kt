package com.gmail.maks347743.feature_gamelist_impl.ui

import android.app.Activity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.gmail.maks347743.core_ui_utils.base.BaseItem
import com.gmail.maks347743.feature_gamelist_impl.CategoryType
import com.gmail.maks347743.feature_gamelist_impl.R
import com.gmail.maks347743.feature_gamelist_impl.databinding.*
import com.gmail.maks347743.feature_gamelist_impl.model.*
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun horizontalGameListDelegate(
    onItemBind: (GamesHorizontalListItem) -> Unit,
    onReadyToLoadMore: (CategoryType, Int) -> Unit
) =
    adapterDelegateViewBinding<GamesHorizontalListItem, BaseItem, ItemGamesHorizontalBinding>(
        viewBinding = { inflater, container ->
            ItemGamesHorizontalBinding.inflate(inflater, container, false)
        },
        block = {
            val adapter = GamesAdapter { position -> onReadyToLoadMore.invoke(item.type, position) }
            binding.recyclerHorizontalGameList.itemAnimator = null
            binding.recyclerHorizontalGameList.adapter = adapter
            bind { payloads ->
                onItemBind.invoke(item)
                if (payloads.isNotEmpty()) {
                    adapter.items = payloads[0] as List<BaseItem>
                } else {
                    binding.titleTextView.text = item.title
                    adapter.items = item.games
                }
            }
        })

fun wideGameDelegate(onReadyToLoadMore: (Int) -> Unit) =
    adapterDelegateViewBinding<GameWideItem, BaseItem, ItemGameWideBinding>(
        viewBinding = { inflater, container ->
            ItemGameWideBinding.inflate(inflater, container, false)
        },
        block = {
            bind {
                Glide.with(binding.root)
                    .load(item.imageUrl)
                    .transform(
                        CenterCrop(),
                        RoundedCorners(binding.root.resources.getDimensionPixelOffset(R.dimen.recycler_item_corner))
                    )
                    .transition(withCrossFade())
                    .into(binding.imageView)
                binding.title = item.title
                binding.executePendingBindings()
                onReadyToLoadMore.invoke(adapterPosition)
            }
            onViewRecycled {
                if ((binding.root.context as? Activity)?.isDestroyed == false) {
                    Glide.with(binding.root).clear(binding.imageView)
                }
            }
        }
    )

fun wideProgressDelegate() =
    adapterDelegateViewBinding<ProgressWideItem, BaseItem, ItemProgressWideBinding>(
        viewBinding = { inflater, container ->
            ItemProgressWideBinding.inflate(inflater, container, false)
        },
        block = {}
    )

fun thinGameDelegate(onReadyToLoadMore: (Int) -> Unit) =
    adapterDelegateViewBinding<GameThinItem, BaseItem, ItemGameThinBinding>(
        viewBinding = { inflater, container ->
            ItemGameThinBinding.inflate(inflater, container, false)
        },
        block = {
            bind {
                Glide.with(binding.root)
                    .load(item.imageUrl)
                    .transform(
                        CenterCrop(),
                        RoundedCorners(binding.root.resources.getDimensionPixelOffset(R.dimen.recycler_item_corner))
                    )
                    .transition(withCrossFade())
                    .into(binding.imageView)
                binding.title = item.title
                binding.executePendingBindings()
                onReadyToLoadMore.invoke(adapterPosition)
            }
            onViewRecycled {
                if ((binding.root.context as? Activity)?.isDestroyed == false) {
                    Glide.with(binding.root).clear(binding.imageView)
                }
            }
        }
    )

fun thinProgressDelegate() =
    adapterDelegateViewBinding<ProgressThinItem, BaseItem, ItemProgressThinBinding>(
        viewBinding = { inflater, container ->
            ItemProgressThinBinding.inflate(inflater, container, false)
        },
        block = {}
    )
