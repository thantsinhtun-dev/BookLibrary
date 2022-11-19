package com.stone.booklibrary.mvp.presenter

import com.stone.booklibrary.mvp.view.CreateShelvesView

interface CreateShelvesPresenter:BasePresenter {
    fun init(view:CreateShelvesView)
    fun onAddNewShelves(shelves: String)
}