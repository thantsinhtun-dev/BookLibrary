package com.stone.booklibrary.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.ShelfVO
import com.stone.booklibrary.delegate.OnClickCheckBoxDelegate
import kotlinx.android.synthetic.main.item_addto_shelves.view.*

class AddToShelvesViewHolder(itemView: View, val mDelegate: OnClickCheckBoxDelegate) :RecyclerView.ViewHolder(itemView) {
    var shelvesVO:ShelfVO? = null
    init {
//        itemView.setOnClickListener {
//            shelvesVO?.let { it1 -> mDelegate.onClickCheckBox(it1) }
//        }
        itemView.cbShelves.setOnCheckedChangeListener { compoundButton, b ->
            shelvesVO?.let { it1 -> mDelegate.onClickCheckBox(it1) }
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