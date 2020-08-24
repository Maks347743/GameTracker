package com.gmail.maks347743.feature_gamelist_impl.api

sealed class PagingState<out T> {
    object Initial : PagingState<Nothing>()
    data class Content<T>(val data: T) : PagingState<T>()
    data class Paging<T>(val previousContent: T) : PagingState<T>()
}