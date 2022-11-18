package com.stone.booklibrary.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import com.stone.booklibrary.viewholders.BookViewHolder

class BookAdapter(private val mDelegate: OverviewBookViewHolderDelegate) :RecyclerView.Adapter<BookViewHolder>() {
    var booksList:List<BookVO> = arrayListOf()
    var displayName:String = ""
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book_vertical,parent,false)
        return BookViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        if (booksList.isNotEmpty()){
            booksList[position].listName = displayName
            holder.bindData(booksList[position])
        }
    }

    override fun getItemCount(): Int {
        return booksList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(books: List<BookVO>, displayName: String){
        this.booksList = books
        this.displayName = displayName
        notifyDataSetChanged()
    }
}