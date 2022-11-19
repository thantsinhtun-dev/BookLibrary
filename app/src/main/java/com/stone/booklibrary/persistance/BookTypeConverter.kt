package com.stone.booklibrary.persistance

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.stone.booklibrary.data.vo.BookVO

class BookTypeConverter {
    @TypeConverter
    fun toString(collection: List<BookVO>?):String{
        return Gson().toJson(collection)
    }

    @TypeConverter
    fun toCollectionVO(genreIdString: String): List<BookVO>?{
        val collectionType=object  : TypeToken<List<BookVO>>() {}.type
        return Gson().fromJson(genreIdString,collectionType)

    }
}