package com.stone.booklibrary.data.models

import androidx.lifecycle.LiveData
import com.stone.booklibrary.data.vo.BookOverviewVO
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.data.vo.ShelfVO
import com.stone.booklibrary.network.responses.BookListResult

interface AppModel {
    fun getOverviewBook(
        onSuccess:(List<BookOverviewVO>)->Unit,
        onFailure:(String)->Unit
    )
    fun getAllRecentBook(
        onFailure:(String)->Unit
    ):LiveData<List<BookVO>>?

    fun setRecentBook(
        bookVO: BookVO
    )
    fun getBookList(
        bookListName:String,
        onSuccess:(List<BookListResult>)->Unit,
        onFailure:(String)->Unit
    )
    fun getAllShelves(
        onFailure:(String)->Unit
    ):LiveData<List<ShelfVO>>?
    fun createNewShelves(
        string: String
    )
    fun addBookToShelves(
        bookVO: ShelfVO?
    )

    fun getShelvesByName(
        shelvesName:String,
        onFailure:(String)->Unit
    ): LiveData<ShelfVO>?

    fun deleteShelves(
        shelfVO: String
    )
    fun changeShelfTitle(
        shelfVO: ShelfVO?
    )

}