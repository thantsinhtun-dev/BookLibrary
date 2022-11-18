package com.stone.booklibrary.data.models

import androidx.lifecycle.LiveData
import com.stone.booklibrary.data.vo.BookOverviewVO
import com.stone.booklibrary.data.vo.BookVO
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

}