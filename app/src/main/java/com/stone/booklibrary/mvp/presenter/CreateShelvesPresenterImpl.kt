package com.stone.booklibrary.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.mvp.view.CreateShelvesView

class CreateShelvesPresenterImpl:ViewModel(),CreateShelvesPresenter {
    private var mView: CreateShelvesView? = null
    private var mAppModel: AppModel = AppModelImpl
    override fun init(view: CreateShelvesView) {
        mView = view
    }

    override fun onAddNewShelves(shelvesVO: String) {
        mAppModel.createNewShelves(shelvesVO)
        mView?.addNewShelves()
    }

    override fun onUIReady(owner: LifecycleOwner) {
    }
}