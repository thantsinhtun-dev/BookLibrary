package com.stone.booklibrary.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stone.booklibrary.data.vo.ShelvesVO

@Dao
interface ShelvesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShelves(movies:List<ShelvesVO>):List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleShelves(movieVO: ShelvesVO)

    @Query("Select * from shelves")
    fun getAllShelves(): LiveData<List<ShelvesVO>>

    @Query("delete from shelves")
    fun deleteAllMovies()
}