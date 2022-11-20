package com.stone.booklibrary.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.BookCategoryViewHolderDelegate
import com.stone.booklibrary.viewholders.BookCategoryListStyle
import com.stone.booklibrary.viewholders.BookCategorySmallStyle
import com.stone.booklibrary.viewpods.ListStyle

class CategoryBookSmallListAdapter (private val mDelegate: BookCategoryViewHolderDelegate): RecyclerView.Adapter<BookCategorySmallStyle>() {
    private var bookList:List<BookVO> = arrayListOf()

    //    private var listStyle:ListStyle = ListStyle.LIST
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookCategorySmallStyle {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book_style_small,parent,false)
        return BookCategorySmallStyle(view,mDelegate)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(books: List<BookVO>){
        bookList = books
        notifyDataSetChanged()
    }





    override fun onBindViewHolder(holder: BookCategorySmallStyle, position: Int) {
        if (bookList.isNotEmpty()){
            holder.bindData(bookList[position])
        }
    }
}