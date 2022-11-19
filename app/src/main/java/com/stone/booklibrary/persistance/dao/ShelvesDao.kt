package com.stone.booklibrary.persistance.dao

import android.service.quicksettings.Tile
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.stone.booklibrary.data.vo.ShelfVO

@Dao
interface ShelvesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShelves(movies:List<ShelfVO>):List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleShelves(movieVO: ShelfVO)

    @Query("Select * from shelves")
    fun getAllShelves(): LiveData<List<ShelfVO>>

    @Query("Select * from shelves  where shelves_title=:shelves")
    fun getShelves(shelves:String): LiveData<ShelfVO>

    @Query("delete from shelves where shelves_title=:shelfTile")
    fun deleteShelf(shelfTile: String)

    @Update()
    fun changeShelfTitle(shelf: ShelfVO)
}