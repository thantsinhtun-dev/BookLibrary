package com.stone.booklibrary

import android.app.Application
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.data.models.SearchBookModelImpl

class BookApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AppModelImpl.initDatabase(applicationContext)
        SearchBookModelImpl.initDatabase(applicationContext)
    }
}