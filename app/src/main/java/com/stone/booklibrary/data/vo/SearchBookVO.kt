package com.stone.booklibrary.data.vo

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class SearchBookVO(
    @SerializedName("title")
    val title: String,
    @SerializedName(  "authors")
    val author: List<String>,
    @SerializedName("description")
    val description: String?,

    @ColumnInfo(name = "publisher")
    val publisher: String?,

    @SerializedName("publishedDate")
    val publishedDate: String?,


    @SerializedName(  "categories")
    var listName: List<String>?,

    @SerializedName("imageLinks")
    val bookImage: BookImage?,
)
data class BookImage(
    @SerializedName("smallThumbnail")
    val image:String?
)