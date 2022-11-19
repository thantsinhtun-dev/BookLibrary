package com.stone.booklibrary.data.models

import android.content.Context
import android.util.Log
import com.stone.booklibrary.BuildConfig
import com.stone.booklibrary.data.vo.SearchBookVO
import com.stone.booklibrary.network.ApiService
import com.stone.booklibrary.network.SearchBookApiService
import com.stone.booklibrary.network.responses.SearchBookVolumeInfo
import com.stone.booklibrary.persistance.BookDatabase
import com.stone.booklibrary.utils.BASE_URL
import com.stone.booklibrary.utils.SEARCH_BOOK_BASE_URL
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object SearchBookModelImpl:SearchBookModel {
    private var mApiService: SearchBookApiService
    private var mBooksDatabase: BookDatabase? = null


    init {
        val mClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            mClient.addInterceptor(logging)
        }
        val retrofit = Retrofit.Builder()
            .baseUrl(SEARCH_BOOK_BASE_URL)
            .client(mClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        mApiService = retrofit.create(SearchBookApiService::class.java)
    }
    fun initDatabase(context: Context){
        mBooksDatabase = BookDatabase.getBookLibraryDB(context)
    }

    override fun getBooksByQuery(
        query: String,
        onSuccess: (List<SearchBookVolumeInfo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApiService.getSearchBooks(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       onSuccess(it.items)
                Log.i("Goooo",it.toString())
            },{
                onFailure(it.localizedMessage ?: "")
            })

    }


}