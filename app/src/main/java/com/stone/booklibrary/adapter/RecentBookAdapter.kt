package com.stone.booklibrary.adapter

import alirezat775.lib.carouselview.CarouselAdapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import kotlinx.android.synthetic.main.item_recent_book_main.view.*

class RecentBookAdapter : CarouselAdapter() {
    private var bookList: List<BookVO> = arrayListOf()
    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        if (bookList.isNotEmpty()) {
            (holder as RecentBookViewHolder).bindData(bookList[position])
        }
    }

    override fun getItemCount(): Int {
        return  bookList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_book_main,parent,false)
        return  RecentBookViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(books: List<BookVO>?) {
        if (books != null) {
            bookList = books
            notifyDataSetChanged()
        }
    }

    inner class RecentBookViewHolder(itemView: View) : CarouselViewHolder(itemView) {
        fun bindData(bookVO: BookVO){
            Glide.with(itemView.context)
                .load(bookVO.bookImage)
                .into(itemView.ivRecentBook)
            itemView.ivRecentBook.scaleType = ImageView.ScaleType.FIT_XY
        }

    }
}