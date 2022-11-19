package com.stone.booklibrary.network

import com.stone.booklibrary.network.responses.BookOverviewListResponse
import com.stone.booklibrary.network.responses.SearchBookResponse
import com.stone.booklibrary.utils.*
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchBookApiService {
    @GET(API_SEARCH_BOOK)
    fun getSearchBooks(
        @Query(PARAM_SEARCH_BOOK) query: String,
    ): Observable<SearchBookResponse>
}