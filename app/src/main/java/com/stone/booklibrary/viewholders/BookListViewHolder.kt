package com.stone.booklibrary.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import com.stone.booklibrary.network.responses.BookListResult
import kotlinx.android.synthetic.main.item_book_list.view.*

class BookListViewHolder(itemView: View, mDelegate: OverviewBookViewHolderDelegate) :RecyclerView.ViewHolder(itemView){
    private var bookVO:BookVO? = null
    init {
        itemView.imgBook.setOnClickListener {
            bookVO?.let { book -> mDelegate.onClickBook(book) }
        }
    }
    fun bindData(bookListResult: BookListResult) {

//        this.bookVO = bookListResult.bookDetails[0]
//        itemView.txtBookName.text = bookVO?.title
//        itemView.txtBookAuthor.text = bookVO?.author
//        Glide.with(itemView.context)
//            .load(bookVO?.bookImage)
//            .placeholder(R.drawable.ic_person_24)
//            .into(itemView.imgBook)
    }
}