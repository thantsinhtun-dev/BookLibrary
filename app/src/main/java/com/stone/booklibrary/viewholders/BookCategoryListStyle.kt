package com.stone.booklibrary.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.BookCategoryViewHolderDelegate
import kotlinx.android.synthetic.main.item_book_style_list.view.*

class BookCategoryListStyle(itemView: View, mDelegate: BookCategoryViewHolderDelegate) :
    RecyclerView.ViewHolder(itemView){
    private var bookVO: BookVO? = null
    init {
        itemView.ivSearchBook.setOnClickListener {
            bookVO?.let { book -> mDelegate.onClickBook(book) }
        }
        itemView.ivMore.setOnClickListener {
            bookVO?.let { book->mDelegate.onClickBookMore(book) }
        }
    }
    fun bindData(bookListResult: BookVO) {

        this.bookVO = bookListResult
        itemView.tvBookTitle.text = bookVO?.title
        itemView.tvBookAuthor.text = bookVO?.author
        Glide.with(itemView.context)
            .load(bookVO?.bookImage)
            .placeholder(R.drawable.book)
            .into(itemView.ivSearchBook)
    }
}