package com.stone.booklibrary.viewholders

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.BookCategoryViewHolderDelegate
import com.stone.booklibrary.viewpods.ListStyle
import kotlinx.android.synthetic.main.item_book_horizontal.view.*
import kotlinx.android.synthetic.main.item_book_list.view.*

class CategoryBookListViewHolder(
    itemView: View,
    mDelegate: BookCategoryViewHolderDelegate,
) :RecyclerView.ViewHolder(itemView) {
    private var bookVO: BookVO? = null
    init {
        itemView.imgBook.setOnClickListener {
            bookVO?.let { book -> mDelegate.onClickBook(book) }
        }
        itemView.imgMore.setOnClickListener {
            bookVO?.let { book->mDelegate.onClickBookMore(book) }
        }
    }
    fun bindData(bookListResult: BookVO) {
        this.bookVO = bookListResult

            itemView.txtBookName.text = bookVO?.title
            itemView.txtBookAuthor.text = bookVO?.author

            bookVO?.bookImage?.let { Log.i("Gooimg", it) }
            Glide.with(itemView.context)
                .load(bookVO?.bookImage)
                .placeholder(R.drawable.ic_person_24)
                .into(itemView.imgBook)

    }
}