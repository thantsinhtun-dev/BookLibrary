package com.stone.booklibrary.mvp.view

import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.viewpods.ListStyle
import com.stone.booklibrary.viewpods.SortType

interface ShelvesDetailView :BaseView{
    fun getAllBooks(books: List<BookVO>)
    fun onClickBookCategory(bookVO: List<BookVO>)
    fun onClickCancelImage()
    fun onClickMore()
    fun onClickBack()
    fun onTapRecyclerViewStyle()
    fun onTapSortList()
    fun changeRecyclerViewStyle(listStyle: ListStyle)
    fun rebuildList(books: List<BookVO>)
    fun addToShelves(bookVO: BookVO)
    fun editShelvesName(isEdit:Boolean)
    fun sortList(sortType: SortType)


}