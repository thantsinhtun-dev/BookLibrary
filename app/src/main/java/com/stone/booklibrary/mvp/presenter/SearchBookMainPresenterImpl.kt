package com.stone.booklibrary.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.data.models.SearchBookModel
import com.stone.booklibrary.data.models.SearchBookModelImpl
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.mvp.view.SearchBookView
import com.stone.booklibrary.network.responses.SearchBookVolumeInfo

class SearchBookMainPresenterImpl:ViewModel(),SearchBookMainPresenter {
    private  var  mView: SearchBookView? = null

    private  val mModel: SearchBookModel = SearchBookModelImpl
    private  val mAppModel: AppModel = AppModelImpl
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

    override fun onClickSearchBook(book: SearchBookVolumeInfo) {
        val bookVO = BookVO(
            0,
            title = book.searchBookVO?.title ?:"",
            author = book.searchBookVO?.author?.get(0) ?: "",
            contributor = book.searchBookVO?.publisher,
            description = book.searchBookVO?.description,
            createdDate = book.searchBookVO?.publishedDate,
            bookImage = book.searchBookVO?.bookImage?.image,
            listName = book.searchBookVO?.listName?.get(0) ?: "Non Category"
        )
        mAppModel.setRecentBook(bookVO)
        mView?.navigateToBookDetail(bookVO)

    }
}