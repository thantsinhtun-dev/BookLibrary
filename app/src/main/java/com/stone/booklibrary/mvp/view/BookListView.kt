package com.stone.booklibrary.mvp.view

import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.network.responses.BookListResult

interface BookListView :BaseView{
    fun getAllBooks(books: List<BookListResult>)
    fun navigateBack()
    fun onTapBook(bookVO: BookVO)
    fun addToShelves(bookVO: BookVO)
    fun navigateToBookDetail(bookVO: BookVO)
}