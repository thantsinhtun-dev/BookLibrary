package com.stone.booklibrary.delegate

import com.stone.booklibrary.data.vo.BookVO

interface BookCategoryViewHolderDelegate {
    fun onClickBookCategory(bookVO: BookVO)
    fun onClickBook(bookVO: BookVO)
    fun onClickBookMore(bookVO: BookVO)
    fun onClickRecyclerViewStyle()
    fun onClickSortList()
}