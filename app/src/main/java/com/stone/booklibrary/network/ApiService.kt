package com.stone.booklibrary.network

import com.stone.booklibrary.network.responses.BookListResponse
import com.stone.booklibrary.network.responses.BookOverviewListResponse
import com.stone.booklibrary.utils.*
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*

interface ApiService {
    @GET(API_GET_OVERVIEW)
    fun getOverviewBooks(
        @Query(PARAM_API_KEY) apiKey: String= API_KEY,
    ): Observable<BookOverviewListResponse>


    @GET(API_GET_BOOK_LIST)
    fun getBookList(

        @Query(PARAM_API_KEY) apiKey: String= API_KEY,
        @Query(PARAM_LIST_NAME,encoded = true) listName: String,
        ):Observable<BookListResponse>

}