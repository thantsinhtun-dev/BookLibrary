package com.stone.booklibrary.data.vo

import com.google.gson.annotations.SerializedName

data class BookOverviewVO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("list_name")
    val displayName: String,
    @SerializedName("list_name_encoded")
    val listNameEncoded: String,
    @SerializedName("books")
    val bookList: List<BookVO>
)