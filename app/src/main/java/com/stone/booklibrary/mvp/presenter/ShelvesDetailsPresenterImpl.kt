package com.stone.booklibrary.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.data.vo.ShelfVO
import com.stone.booklibrary.mvp.view.ShelvesDetailView
import com.stone.booklibrary.viewpods.ListStyle

class ShelvesDetailsPresenterImpl:ViewModel(),ShelvesDetailPresenter {
    private  var  mView: ShelvesDetailView? = null
    private  val mAppMode:AppModel = AppModelImpl
    private  var books: List<BookVO>? =null
    override fun initView(view: ShelvesDetailView) {
        mView = view
    }

    override fun onClickBack() {
       mView?.onClickBack()
    }

    override fun onClickMore() {
        mView?.onClickMore()
    }

    override fun onClickCategory() {

    }

    override fun onClickCancelImg() {

        books?.let {
            for (book in it){
                book.selected = false
            }
            mView?.onClickBookCategory(it)
            mView?.rebuildList(it)
            mView?.onClickCancelImage()
        }

    }

    override fun onUIReady(owner: LifecycleOwner, shelvesName: String) {
        mAppMode.getShelvesByName(shelvesName){
            mView?.showError(it)
        }?.observe(owner){
            it?.bookLists?.let { it1 ->
                mView?.getAllBooks(it1)
                books=it1
            }
        }
    }

    override fun onUIReady(owner: LifecycleOwner) {

    }

    override fun changeShelfTitle(shelfVO: ShelfVO?) {
        mView?.editShelvesName(isEdit = false)
        mAppMode.changeShelfTitle(shelfVO)

    }

    override fun onClickBookCategory(bookVO: BookVO) {
        books?.let {
            for ((index, book) in it.withIndex()) {
                if (bookVO.listName == book.listName) {
                    book.selected = true
                    book.index = 0

                } else {
                    book.selected = false
                    book.index = index + 1
                }
            }
            mView?.onClickBookCategory(it.sortedBy { it.index })
            mView?.rebuildList(it.filter { it.listName == bookVO.listName })
        }


    }

    override fun onClickBook(bookVO: BookVO) {
    }

    override fun onClickBookMore(bookVO: BookVO) {
        mView?.showBookBottomSheet(bookVO)
    }

    override fun onClickRecyclerViewStyle() {
        mView?.onTapRecyclerViewStyle()
    }

    override fun onClickSortList() {mView?.onTapSortList()

    }

    override fun chooseListStyle(listStyle: ListStyle) {
        mView?.changeRecyclerViewStyle(listStyle)
    }

    override fun onClickAddToShelves(bookVO: BookVO) {
        mView?.addToShelves(bookVO)
    }

    override fun onClickEdit() {
        mView?.editShelvesName(isEdit = true)
    }

    override fun onClickDelete(shelfTitle: String) {
        mAppMode.deleteShelves(shelfTitle)
        mView?.onClickBack()
    }
}