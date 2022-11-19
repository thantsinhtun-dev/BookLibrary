package com.stone.booklibrary.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.data.vo.ShelfVO
import com.stone.booklibrary.mvp.view.AddToShelvesView

class AddToShelvesPresenterImpl:ViewModel(),AddToShelvesPresenter {
    private var mView: AddToShelvesView? = null
    private var mAppModel: AppModel = AppModelImpl
    override fun init(addToShelvesView: AddToShelvesView) {
        mView = addToShelvesView
    }

    override fun onClickCheckBox(bookVO: ShelfVO?) {
        mAppModel.addBookToShelves(bookVO)
    }

    override fun onUIReady(owner: LifecycleOwner) {
        mAppModel.getAllShelves {
            mView?.showError(it)
        }?.observe(owner){
            mView?.getALLShelves(it)
        }


    }
}