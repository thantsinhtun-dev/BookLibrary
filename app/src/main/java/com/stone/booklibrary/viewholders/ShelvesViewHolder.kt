package com.stone.booklibrary.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.ShelfVO
import com.stone.booklibrary.mvp.presenter.ShelvesListPresenter
import kotlinx.android.synthetic.main.item_shelves.view.*

class ShelvesViewHolder(itemView: View, val mDelegate: ShelvesListPresenter) :RecyclerView.ViewHolder(itemView) {

    var shelvesVO:ShelfVO? = null
    init {
        itemView.setOnClickListener {
            shelvesVO?.let { it1 -> mDelegate.onClickShelves(it1) }
        }
    }
    fun bindData(shelvesVO: ShelfVO) {
        this.shelvesVO = shelvesVO
        itemView.tvShelvesName.text = shelvesVO.shelvesTitle
        itemView.tvShelvesBookCount.text = shelvesVO.bookLists?.size.toString() + "books"

        Glide.with(itemView.context)
            .load(shelvesVO.bookLists?.firstOrNull()?.bookImage)
            .placeholder(R.drawable.book)
            .into(itemView.imgShelves)
    }
}