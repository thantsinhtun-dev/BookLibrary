package com.stone.booklibrary.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.BookCategoryViewHolderDelegate
import com.stone.booklibrary.viewholders.BookCategoryViewHolder

class BookCategoryAdapter(val mDelegate: BookCategoryViewHolderDelegate) :RecyclerView.Adapter<BookCategoryViewHolder>() {
    private var books:List<BookVO> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book_category,parent,false)
        return BookCategoryViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: BookCategoryViewHolder, position: Int) {
        if (books.isNotEmpty()){
            holder.bindData(books[position])
        }
    }

    override fun getItemCount(): Int {
        return  books.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewDate(books: List<BookVO>) {
        this.books = books.distinctBy { it.listName }
        notifyDataSetChanged()
    }
}