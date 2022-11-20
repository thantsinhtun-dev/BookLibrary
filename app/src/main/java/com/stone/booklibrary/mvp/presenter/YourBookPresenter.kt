package com.stone.booklibrary.mvp.presenter

import com.stone.booklibrary.delegate.*
import com.stone.booklibrary.mvp.view.YourBookView

interface YourBookPresenter:BasePresenter,BookCategoryViewHolderDelegate,ChooseRecyclerViewStyleDelegate,AddToShelvesDelegate,SortListDelegate {
    fun init(view:YourBookView)
    fun onClickCategory()
    fun onClickCancelImg()
}