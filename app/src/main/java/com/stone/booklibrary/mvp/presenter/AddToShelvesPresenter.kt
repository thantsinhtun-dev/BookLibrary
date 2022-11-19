package com.stone.booklibrary.mvp.presenter

import com.stone.booklibrary.data.vo.ShelfVO
import com.stone.booklibrary.mvp.view.AddToShelvesView

interface AddToShelvesPresenter:BasePresenter {
    fun init(addToShelvesView: AddToShelvesView)
    fun onClickCheckBox(bookVO: ShelfVO?)
}