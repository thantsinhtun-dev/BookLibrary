package com.stone.booklibrary.data.models

import com.stone.booklibrary.data.vo.SearchBookVO
import com.stone.booklibrary.network.responses.SearchBookVolumeInfo

interface SearchBookModel {
   fun getBooksByQuery(
      query:String,
      onSuccess:(List<SearchBookVolumeInfo>)->Unit,
      onFailure:(String)->Unit
   )
}