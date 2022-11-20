package com.stone.booklibrary.mvp.presenter

import com.stone.booklibrary.delegate.SearchBookDelegate
import com.stone.booklibrary.mvp.view.SearchBookView

interface SearchBookMainPresenter :BasePresenter,SearchBookDelegate{
    fun initView(view:SearchBookView)
    fun onSearchBook(query:String)
    fun onTapBack()
}