package com.stone.booklibrary.data.vo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.stone.booklibrary.persistance.BookTypeConverter

@Entity(tableName = "shelves")
@TypeConverters(BookTypeConverter::class)
data class ShelfVO(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "shelves_title")
    var shelvesTitle: String,
    @ColumnInfo(name = "book_lists")
    var bookLists: MutableList<BookVO>?
):java.io.Serializable