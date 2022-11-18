package com.stone.booklibrary.network.responses

import com.google.gson.annotations.SerializedName
import com.stone.booklibrary.data.vo.BookOverviewVO

data class BookOverviewListResponse(
    @SerializedName("status")
    val status:String,
    @SerializedName("results")
    val result:BookOverviewResultList
)
data class BookOverviewResultList(
    @SerializedName("lists")
    val bookList:List<BookOverviewVO>?
)