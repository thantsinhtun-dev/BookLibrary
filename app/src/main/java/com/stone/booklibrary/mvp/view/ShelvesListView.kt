package com.stone.booklibrary.mvp.view

import com.stone.booklibrary.data.vo.ShelvesVO

interface ShelvesListView :BaseView{
    fun getAllShelves(shelves:List<ShelvesVO>)
    fun onTapShelves(shelvesVO: ShelvesVO)
    fun onTapCreateShelves()
}