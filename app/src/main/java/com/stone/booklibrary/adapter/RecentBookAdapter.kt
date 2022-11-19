package com.stone.booklibrary.adapter

import alirezat775.lib.carouselview.CarouselAdapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import com.stone.booklibrary.mvp.presenter.HomePresenter
import kotlinx.android.synthetic.main.item_recent_book_main.view.*

class RecentBookAdapter(val mDelegate: OverviewBookViewHolderDelegate) : CarouselAdapter() {
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
        return  RecentBookViewHolder(view,mDelegate)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(books: List<BookVO>?) {
        if (books != null) {
            bookList = books
            notifyDataSetChanged()
        }
    }

    inner class RecentBookViewHolder(itemView: View, mDelegate: OverviewBookViewHolderDelegate) : CarouselViewHolder(itemView) {
        var bookVO:BookVO? = null
        fun bindData(bookVO: BookVO){
            this.bookVO = bookVO
            Glide.with(itemView.context)
                .load(bookVO.bookImage)
                .placeholder(R.drawable.book)
                .into(itemView.imgBook)
        }
        init {
            itemView.imgMore.setOnClickListener {
                bookVO?.let {book-> mDelegate.onClickBookMore(book) }
            }
        }

    }
}