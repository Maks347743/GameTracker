package com.gmail.maks347743.feature_gamelist_impl.api

private const val DATES = "dates"
private const val ORDERING = "ordering"

data class GamesApiParams(
  /*  val page: Int? = null,
    val pageSize: Int? = null,*/
    val dates: String? = null,
    val ordering: String? = null
) {

    fun toMap(): Map<String, String> = mutableMapOf<String, String>().apply {
       /* page?.let { put(PAGE, it.toString()) }
        pageSize?.let { put(PAGE_SIZE, it.toString()) }*/
        dates?.let { put(DATES, it) }
        ordering?.let { put(ORDERING, it) }
    }

}