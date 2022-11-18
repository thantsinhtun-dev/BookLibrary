package com.stone.booklibrary.mvp.presenter

import com.stone.booklibrary.mvp.view.HomeView


interface HomePresenter:BasePresenter {
    fun initView(view: HomeView)
}