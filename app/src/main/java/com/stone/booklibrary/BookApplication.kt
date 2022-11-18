package com.stone.booklibrary

import android.app.Application
import com.stone.booklibrary.data.models.AppModelImpl

class BookApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AppModelImpl.initDatabase(applicationContext)
    }
}