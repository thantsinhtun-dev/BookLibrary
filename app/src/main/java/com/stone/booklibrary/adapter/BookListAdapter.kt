package com.stone.booklibrary.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import com.stone.booklibrary.network.responses.BookListResult
import com.stone.booklibrary.viewholders.BookListViewHolder

class BookListAdapter(private val mDelegate: OverviewBookViewHolderDelegate):RecyclerView.Adapter<BookListViewHolder>() {
    private var bookList:List<BookListResult> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book_list,parent,false)
        return BookListViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        if (bookList.isNotEmpty()){
            holder.bindData(bookList[position])
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(books: List<BookListResult>){
        bookList = books
        notifyDataSetChanged()
    }
}