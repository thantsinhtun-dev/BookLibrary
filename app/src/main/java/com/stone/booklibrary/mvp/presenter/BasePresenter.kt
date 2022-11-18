package com.stone.booklibrary.mvp.presenter

import androidx.lifecycle.LifecycleOwner

interface BasePresenter {
    fun onUIReady(owner: LifecycleOwner)
}