package com.stone.booklibrary.viewholders

import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.BookCategoryViewHolderDelegate
import kotlinx.android.synthetic.main.item_book_category.view.*

class BookCategoryViewHolder(itemView: View, mDelegate: BookCategoryViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {
    var bookVO:BookVO? = null
    init {
        itemView.chipBookCategory.setOnClickListener {
            bookVO?.let { book -> mDelegate.onClickBookCategory(book) }
        }
    }
    fun bindData(bookVO: BookVO) {
        this.bookVO = bookVO
        itemView.chipBookCategory.text = bookVO.listName

        if (bookVO.selected == true){
            itemView.chipBookCategory.apply {
                    setTextColor(ContextCompat.getColor(context,R.color.white))
                    backgroundTintList =
                        ColorStateList.valueOf(ContextCompat.getColor(itemView.context,R.color.colorPrimary))

            }
        }else{
            itemView.chipBookCategory.apply {
                setTextColor(ContextCompat.getColor(context,R.color.black))
                backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(itemView.context,R.color.white))

            }
        }
    }

}