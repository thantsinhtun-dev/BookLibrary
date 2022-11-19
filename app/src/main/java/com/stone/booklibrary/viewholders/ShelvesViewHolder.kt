package com.stone.booklibrary.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.ShelvesVO
import com.stone.booklibrary.mvp.presenter.ShelvesListPresenter
import kotlinx.android.synthetic.main.item_shelves.view.*

class ShelvesViewHolder(itemView: View, val mDelegate: ShelvesListPresenter) :RecyclerView.ViewHolder(itemView) {

    var shelvesVO:ShelvesVO? = null
    init {
        itemView.setOnClickListener {
            shelvesVO?.let { it1 -> mDelegate.onClickShelves(it1) }
        }
    }
    fun bindData(shelvesVO: ShelvesVO) {
        this.shelvesVO = shelvesVO
        itemView.tvShelvesName.text = shelvesVO.shelvesTitle
        itemView.tvShelvesBookCount.text = shelvesVO.bookLists?.size.toString() + "books"

        Glide.with(itemView.context)
            .load(shelvesVO.bookLists?.firstOrNull()?.bookImage)
            .placeholder(R.drawable.ic_person_24)
            .into(itemView.imgShelves)
    }
}