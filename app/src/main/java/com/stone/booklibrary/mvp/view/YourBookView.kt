package com.stone.booklibrary.mvp.view

import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.viewpods.ListStyle

interface YourBookView :BaseView{
    fun getAllBooks(books: List<BookVO>)
    fun onClickBookCategory(bookVO: List<BookVO>)
    fun onClickCancelImage()
    fun onTapRecyclerViewStyle()
    fun onTapSortList()
    fun changeRecyclerViewStyle(listStyle: ListStyle)
    fun rebuildList(books: List<BookVO>)
}