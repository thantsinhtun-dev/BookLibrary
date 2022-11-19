package com.stone.booklibrary.mvp.presenter

import com.stone.booklibrary.data.vo.ShelvesVO
import com.stone.booklibrary.mvp.view.ShelvesListView

interface ShelvesListPresenter:BasePresenter {
    fun init(view:ShelvesListView)
    fun onClickShelves(shelvesVO: ShelvesVO)
    fun onClickCreateNewShelf()
}