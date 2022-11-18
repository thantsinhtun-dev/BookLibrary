package com.stone.booklibrary.mvp.view

import com.stone.booklibrary.data.vo.BookVO

interface BaseView {
    fun showError(error:String)
    fun showBookBottomSheet(bookVO: BookVO)
}