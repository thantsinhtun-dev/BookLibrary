package com.stone.booklibrary.delegate

import com.stone.booklibrary.network.responses.SearchBookVolumeInfo

interface SearchBookDelegate {
    fun onClickSearchBook(book:SearchBookVolumeInfo)
}