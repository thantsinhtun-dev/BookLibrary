package com.stone.booklibrary.mvp.presenter

import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import com.stone.booklibrary.mvp.view.HomeView


interface HomePresenter:BasePresenter,OverviewBookViewHolderDelegate {
    fun initView(view: HomeView)
}