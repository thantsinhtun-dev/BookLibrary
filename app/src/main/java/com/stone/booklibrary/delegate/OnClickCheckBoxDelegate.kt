package com.stone.booklibrary.delegate

import com.stone.booklibrary.data.vo.ShelfVO

interface OnClickCheckBoxDelegate {
    fun onClickCheckBox(shelvesVO: ShelfVO)
}