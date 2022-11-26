package com.stone.booklibrary.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.stone.booklibrary.data.vo.ShelfVO
import com.stone.booklibrary.delegate.*
import com.stone.booklibrary.mvp.view.ShelvesDetailView

interface ShelvesDetailPresenter:BasePresenter, BookCategoryViewHolderDelegate,
    ChooseRecyclerViewStyleDelegate, AddToShelvesDelegate,ManagementShelfDelegate,
    SortListDelegate {
    fun initView(view:ShelvesDetailView)
    fun onClickBack()
    fun onClickMore()
    fun onClickCategory()
    fun onClickCancelImg()
    fun onUIReady(owner: LifecycleOwner,shelvesName:String)
    fun changeShelfTitle(newTitle: ShelfVO?)

}