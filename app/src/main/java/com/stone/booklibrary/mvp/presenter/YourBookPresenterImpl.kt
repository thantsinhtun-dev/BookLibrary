package com.stone.booklibrary.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.mvp.view.YourBookView
import com.stone.booklibrary.viewpods.ListStyle

class YourBookPresenterImpl : ViewModel(), YourBookPresenter {
    private var mView: YourBookView? = null
    private var mAppModel: AppModel = AppModelImpl

    private lateinit var books: List<BookVO>
    override fun init(view: YourBookView) {
        mView = view
    }

    override fun onClickCategory() {

    }

    override fun onClickCancelImg() {
        mView?.onClickCancelImage()
        for (book in books){
            book.selected = false
        }
        mView?.onClickBookCategory(books)
        mView?.rebuildList(books)
    }

    override fun onUIReady(owner: LifecycleOwner) {
        mAppModel.getAllRecentBook {
            mView?.showError(it)
        }?.observe(owner) {
            books = it
            mView?.getAllBooks(it)
        }
    }

    override fun onClickBookCategory(bookVO: BookVO) {
        for ((index, book) in books.withIndex()) {
            if (bookVO.listName == book.listName) {
                book.selected = true
                book.index = 0

            } else {
                book.selected = false
                book.index = index + 1
            }
        }
        mView?.onClickBookCategory(books.sortedBy { it.index })
        mView?.rebuildList(books.filter { it.listName == bookVO.listName })
    }

    override fun onClickBook(bookVO: BookVO) {

    }



    override fun onClickBookMore(bookVO: BookVO) {
        mView?.showBookBottomSheet(bookVO)
    }

    override fun onClickRecyclerViewStyle() {
        mView?.onTapRecyclerViewStyle()
    }

    override fun onClickSortList() {
        mView?.onTapSortList()
    }

    override fun chooseListStyle(listStyle: ListStyle) {
        mView?.changeRecyclerViewStyle(listStyle)
    }

    override fun onClickAddToShelves(bookVO: BookVO) {
        mView?.addToShelves(bookVO)
    }


}