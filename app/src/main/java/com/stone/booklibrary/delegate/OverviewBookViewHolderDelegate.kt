package com.stone.booklibrary.delegate

import com.stone.booklibrary.data.vo.BookVO

interface OverviewBookViewHolderDelegate {
    fun onClickBook(bookVO: BookVO)
    fun onClickBookList(bookListName:String,encodedName:String)
}