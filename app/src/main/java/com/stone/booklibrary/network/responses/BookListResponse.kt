package com.stone.booklibrary.network.responses

import com.google.gson.annotations.SerializedName
import com.stone.booklibrary.data.vo.BookVO

data class BookListResponse(
    @SerializedName("status")
    val status:String?,
    @SerializedName("results")
    val result:List<BookListResult>?
)
data class BookListResult(
    @SerializedName("list_name")
    val listName:String?,
)