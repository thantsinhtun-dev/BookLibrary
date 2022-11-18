package com.stone.booklibrary.mvp.view

import com.stone.booklibrary.data.vo.BookOverviewVO
import com.stone.booklibrary.data.vo.BookVO

interface EBookView : BaseView {
    fun getAllOverViewBook(overviewBookList: List<BookOverviewVO>)
    fun navigateToBookDetail(bookVO: BookVO)
    fun navigateToBookList(bookListTile: String,bookListTileEncoded: String)

}