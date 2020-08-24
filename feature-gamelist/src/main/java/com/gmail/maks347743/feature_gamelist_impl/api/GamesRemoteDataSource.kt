package com.gmail.maks347743.feature_gamelist_impl.api

import com.gmail.maks347743.core_api.dto.GameDto
import com.gmail.maks347743.core_api.network.GamesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

private const val DEFAULT_PAGE_SIZE = 20
private const val PAGE = "page"
private const val PAGE_SIZE = "page_size"

class GamesRemoteDataSource
@Inject constructor(private val api: GamesApi) : GamesDataSource {

    private val channel = ConflatedBroadcastChannel<PagingState<List<GameDto>>>(PagingState.Initial)
    private var params: GamesApiParams? = null
    private var page = 1

    @Synchronized
    override suspend fun loadInitially(params: GamesApiParams) {
        if (channel.value is PagingState.Initial) {
            val response = api.getGames(params.applyPagingParams())
            this.params = params
            channel.send(PagingState.Content(response.results))
        }
    }

    @Synchronized
    override suspend fun loadMore(index: Int) {
        params?.let {
            val previousValue = channel.value
            if (previousValue is PagingState.Content && index == previousValue.data.size - 1) {
                channel.send(PagingState.Paging(previousValue.data))
                val response = api.getGames(it.applyPagingParams(page = page + 1))
                channel.send(PagingState.Content(previousValue.data + response.results))
                page += 1
            }
        }
    }

    override fun observe(): Flow<PagingState<List<GameDto>>> = channel.asFlow()

    private fun GamesApiParams.applyPagingParams(
        page: Int = 1, pageSize: Int = DEFAULT_PAGE_SIZE
    ): Map<String, String> =
        toMap().toMutableMap().apply {
            put(PAGE, page.toString())
            put(PAGE_SIZE, pageSize.toString())
        }

}

interface GamesDataSource {
    suspend fun loadInitially(params: GamesApiParams)
    suspend fun loadMore(index: Int)
    fun observe(): Flow<PagingState<List<GameDto>>>
}