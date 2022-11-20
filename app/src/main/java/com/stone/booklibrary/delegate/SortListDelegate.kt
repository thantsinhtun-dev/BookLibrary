package com.stone.booklibrary.delegate

import com.stone.booklibrary.viewpods.SortType

interface SortListDelegate {
    fun sortList(sortType: SortType)
}