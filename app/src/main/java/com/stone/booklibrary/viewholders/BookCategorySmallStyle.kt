package com.stone.booklibrary.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.BookCategoryViewHolderDelegate
import kotlinx.android.synthetic.main.item_book_style_small.view.*

class BookCategorySmallStyle(itemView: View, mDelegate: BookCategoryViewHolderDelegate) :
    RecyclerView.ViewHolder(itemView){
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
        Glide.with(itemView.context)
            .load(bookVO?.bookImage)
            .placeholder(R.drawable.book)
            .into(itemView.imgBook)
    }
}