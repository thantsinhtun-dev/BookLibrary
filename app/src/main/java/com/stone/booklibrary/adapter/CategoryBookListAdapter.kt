package com.stone.booklibrary.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.BookCategoryViewHolderDelegate
import com.stone.booklibrary.viewholders.CategoryBookListViewHolder
import com.stone.booklibrary.viewpods.ListStyle

class CategoryBookListAdapter (private val mDelegate: BookCategoryViewHolderDelegate): RecyclerView.Adapter<CategoryBookListViewHolder>() {
    private var bookList:List<BookVO> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryBookListViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book_list,parent,false)
        return CategoryBookListViewHolder(view,mDelegate)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(books: List<BookVO>){
        bookList = books
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CategoryBookListViewHolder, position: Int) {
        if (bookList.isNotEmpty()){
            holder.bindData(bookList[position])
        }
    }
}