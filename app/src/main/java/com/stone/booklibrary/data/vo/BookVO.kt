package com.stone.booklibrary.data.vo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.net.IDN

@Entity(tableName = "books", primaryKeys = ["title","author"])
data class BookVO(
    @SerializedName("author")
    @ColumnInfo(name = "author")
    val author: String,
    @SerializedName("title")
    @ColumnInfo(name = "title")
    val title: String,
    @SerializedName("book_image")
    @ColumnInfo(name = "book_image")
    val bookImage: String?,
    @SerializedName("contributor")
    @ColumnInfo(name = "contributor")
    val contributor: String?,
    @SerializedName("create_date")
    @ColumnInfo(name = "create_date")
    val createdDate: String?,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String?,

)