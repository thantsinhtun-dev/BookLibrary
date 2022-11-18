package com.stone.booklibrary.mvp.presenter

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.mvp.view.HomeView

class HomePresenterImpl:ViewModel(),HomePresenter {
    private var mView: HomeView? = null
    private var mAppModel: AppModel = AppModelImpl
    override fun initView(view: HomeView) {
        mView = view
    }

    override fun onUIReady(owner: LifecycleOwner) {
        mAppModel.getAllRecentBook {
            mView?.showError(it)
        }?.observe(owner){
            Log.i("Gooo","liveData")
            mView?.getAllRecentBook(it)
        }
    }

    override fun onClickBook(bookVO: BookVO) {

    }

    override fun onClickBookList(bookListName: String, encodedName: String) {
    }

    override fun onClickBookMore(bookVO: BookVO) {
        mView?.showBookBottomSheet(bookVO)
    }
}