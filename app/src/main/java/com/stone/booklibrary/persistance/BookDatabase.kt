package com.stone.booklibrary.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stone.booklibrary.data.vo.BookVO

@Database(entities = [BookVO::class], version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {
    companion object {
        private const val dbName = "BOOK_LIBRARY"
        var dbInstance: BookDatabase? = null
        fun getBookLibraryDB(context: Context): BookDatabase? {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, BookDatabase::class.java, dbName)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return dbInstance
        }
    }
    abstract fun recentBookDao():RecentBookDao
}