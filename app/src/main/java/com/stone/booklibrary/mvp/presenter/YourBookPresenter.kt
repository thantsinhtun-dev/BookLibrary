package com.stone.booklibrary.mvp.presenter

import com.stone.booklibrary.delegate.AddToShelvesDelegate
import com.stone.booklibrary.delegate.BookCategoryViewHolderDelegate
import com.stone.booklibrary.delegate.ChooseRecyclerViewStyleDelegate
import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import com.stone.booklibrary.mvp.view.YourBookView

interface YourBookPresenter:BasePresenter,BookCategoryViewHolderDelegate,ChooseRecyclerViewStyleDelegate,AddToShelvesDelegate {
    fun init(view:YourBookView)
    fun onClickCategory()
    fun onClickCancelImg()
}