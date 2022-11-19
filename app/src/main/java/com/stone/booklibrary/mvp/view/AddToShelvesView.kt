package com.stone.booklibrary.mvp.view

import com.stone.booklibrary.data.vo.ShelfVO

interface AddToShelvesView:BaseView {
    fun getALLShelves(shelves: List<ShelfVO>)
    fun onTapCheckBox()
}