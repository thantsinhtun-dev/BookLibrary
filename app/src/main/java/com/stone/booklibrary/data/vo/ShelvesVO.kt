package com.stone.booklibrary.data.vo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.stone.booklibrary.persistance.BookTypeConverter

@Entity(tableName = "shelves")
@TypeConverters(BookTypeConverter::class)
data class ShelvesVO(
    @PrimaryKey
    @ColumnInfo(name = "shelves_title")
    val shelvesTitle: String,
    @ColumnInfo(name = "book_lists")
    val bookLists: List<BookVO>?
)