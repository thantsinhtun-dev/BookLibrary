package com.stone.booklibrary.network.responses

import com.google.gson.annotations.SerializedName
import com.stone.booklibrary.data.vo.SearchBookVO

data class SearchBookResponse (
    @SerializedName("items")
    val items:List<SearchBookVolumeInfo>
        )
data class SearchBookVolumeInfo(
    @SerializedName("volumeInfo")
    val searchBookVO: SearchBookVO?
)