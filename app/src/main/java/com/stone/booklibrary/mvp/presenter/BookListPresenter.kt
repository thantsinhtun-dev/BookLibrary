package com.stone.booklibrary.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.stone.booklibrary.delegate.AddToShelvesDelegate
import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import com.stone.booklibrary.mvp.view.BookListView

interface BookListPresenter:BasePresenter,OverviewBookViewHolderDelegate,AddToShelvesDelegate {
    fun initView(view: BookListView)
    fun onUIReadyBookList(owner: LifecycleOwner,bookListName:String)
    fun onTapBack()
}