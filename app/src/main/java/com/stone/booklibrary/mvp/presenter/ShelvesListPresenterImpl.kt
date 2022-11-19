package com.stone.booklibrary.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.data.vo.ShelvesVO
import com.stone.booklibrary.mvp.view.ShelvesListView

class ShelvesListPresenterImpl :ViewModel(),ShelvesListPresenter{
    private var mView: ShelvesListView? = null
    private var mAppModel: AppModel = AppModelImpl
    override fun init(view: ShelvesListView) {
        mView = view
    }

    override fun onClickShelves(shelvesVO: ShelvesVO) {
        mView?.onTapShelves(shelvesVO)
    }

    override fun onClickCreateNewShelf() {
        mView?.onTapCreateShelves()
    }

    override fun onUIReady(owner: LifecycleOwner) {
        mAppModel.getAllShelves {
            mView?.showError(it)
        }?.observe(owner){
            mView?.getAllShelves(it)
        }
    }
}