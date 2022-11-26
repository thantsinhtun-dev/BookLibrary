package com.stone.booklibrary.data.vo

import androidx.room.*
import com.stone.booklibrary.persistance.BookTypeConverter

@Entity(tableName = "shelves",indices = [
    Index(value = ["shelves_title"], unique = true)
])
@TypeConverters(BookTypeConverter::class)
data class ShelfVO(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "shelves_title")
    var shelvesTitle: String,
    @ColumnInfo(name = "book_lists")
    var bookLists: MutableList<BookVO>?
):java.io.Serializable