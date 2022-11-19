package com.stone.booklibrary.delegate


interface ManagementShelfDelegate {
    fun onClickEdit()
    fun onClickDelete(shelfTitle: String)
}