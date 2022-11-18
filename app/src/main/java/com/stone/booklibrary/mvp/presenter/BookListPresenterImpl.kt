package com.stone.booklibrary.mvp.presenter

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.mvp.view.BookListView

class BookListPresenterImpl : ViewModel(), BookListPresenter {
    private var mView: BookListView? = null
    private var mAppModel: AppModel = AppModelImpl
    override fun initView(view: BookListView) {
        mView = view
    }

    override fun onUIReadyBookList(owner: LifecycleOwner, bookListName: String) {
        mAppModel.getBookList(
            bookListName = bookListName,
            onSuccess = {
                mView?.getAllBooks(it)

            },
            onFailure = {
                mView?.showError(it)
            })
    }

    override fun onTapBack() {
        mView?.navigateBack()
    }

    override fun onUIReady(owner: LifecycleOwner) {

    }

    override fun onClickBook(bookVO: BookVO) {
        mView?.onTapBook(bookVO)
        mAppModel.setRecentBook(bookVO)
    }

    override fun onClickBookList(bookListName: String, encodedName: String) {
    }
}