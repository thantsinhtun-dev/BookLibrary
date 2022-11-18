package com.stone.booklibrary.persistance

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stone.booklibrary.data.vo.BookVO

@Dao
interface RecentBookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBooks(movies:List<BookVO>):List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleBook(movieVO: BookVO)

    @Query("Select * from books")
    fun getAllBooks(): LiveData<List<BookVO>>

    @Query("delete from books")
    fun deleteAllMovies()


}