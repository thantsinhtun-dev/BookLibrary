package com.stone.booklibrary.mvp.presenter

import com.stone.booklibrary.delegate.AddToShelvesDelegate
import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import com.stone.booklibrary.mvp.view.EBookView

interface EBookPresenter :BasePresenter,OverviewBookViewHolderDelegate,AddToShelvesDelegate{
    fun initView(view: EBookView)
}