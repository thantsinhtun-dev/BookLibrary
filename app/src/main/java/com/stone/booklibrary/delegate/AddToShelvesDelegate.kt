package com.stone.booklibrary.delegate

import com.stone.booklibrary.data.vo.BookVO

interface AddToShelvesDelegate {
    fun onClickAddToShelves(bookVO: BookVO)
}