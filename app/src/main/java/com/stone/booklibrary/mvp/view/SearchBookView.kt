package com.stone.booklibrary.mvp.view

import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.network.responses.SearchBookVolumeInfo

interface SearchBookView :BaseView{
    fun showSearchBookList(books: List<SearchBookVolumeInfo>)
    fun onTapBack()
    fun navigateToBookDetail(bookVO: BookVO)
}