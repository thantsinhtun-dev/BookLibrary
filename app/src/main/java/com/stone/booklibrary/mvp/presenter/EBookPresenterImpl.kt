package com.stone.booklibrary.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.mvp.view.EBookView

class EBookPresenterImpl : ViewModel(), EBookPresenter {

    private var mView: EBookView? = null
    private var mAppModel: AppModel = AppModelImpl

    override fun initView(view: EBookView) {
        mView = view
    }

    override fun onUIReady(owner: LifecycleOwner) {
        mAppModel.getOverviewBook(
            onSuccess = {
                mView?.getAllOverViewBook(it)
            },
            onFailure = {
                mView?.showError(it)
            }
        )
    }

    override fun onClickBook(bookVO: BookVO) {
        mView?.navigateToBookDetail(bookVO)
        mAppModel.setRecentBook(bookVO)
    }

    override fun onClickBookList(bookListName: String, encodedName: String) {
        mView?.navigateToBookList(bookListName,encodedName)
    }
}