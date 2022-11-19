package com.stone.booklibrary.mvp.view

import com.stone.booklibrary.data.vo.ShelfVO

interface ShelvesListView :BaseView{
    fun getAllShelves(shelves:List<ShelfVO>)
    fun onTapShelves(shelvesVO: ShelfVO)
    fun onTapCreateShelves()
}