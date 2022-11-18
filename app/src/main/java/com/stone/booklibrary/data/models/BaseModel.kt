package com.stone.booklibrary.data.models

import android.content.Context
import com.stone.booklibrary.BuildConfig
import com.stone.booklibrary.network.ApiService
import com.stone.booklibrary.persistance.BookDatabase
import com.stone.booklibrary.utils.BASE_URL
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


abstract  class BaseModel {
    protected var mApiService: ApiService
    protected var mBooksDatabase: BookDatabase? = null

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
            .baseUrl(BASE_URL)
            .client(mClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        mApiService = retrofit.create(ApiService::class.java)
    }
    fun initDatabase(context: Context){
        mBooksDatabase = BookDatabase.getBookLibraryDB(context)
    }
}