package com.stone.booklibrary.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.booklibrary.data.models.SearchBookModel
import com.stone.booklibrary.data.models.SearchBookModelImpl
import com.stone.booklibrary.mvp.view.SearchBookView
class SearchBookMainPresenterImpl:ViewModel(),SearchBookMainPresenter {
    private  var  mView: SearchBookView? = null

    private  val mModel: SearchBookModel = SearchBookModelImpl
    override fun initView(view: SearchBookView) {
        mView = view
    }

    override fun onSearchBook(query: String) {
        mModel.getBooksByQuery(query, onFailure = {
            mView?.showError(it)
        }, onSuccess = {
            mView?.showSearchBookList(it)
        })
    }

    override fun onTapBack() {
        mView?.onTapBack()
    }

    override fun onUIReady(owner: LifecycleOwner) {

    }
}