package com.stone.booklibrary.mvp.view

import com.stone.booklibrary.data.vo.BookVO

interface HomeView :BaseView{
    fun getAllRecentBook(books:List<BookVO>)
}