package com.stone.booklibrary.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookOverviewVO
import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import com.stone.booklibrary.viewholders.OverviewBookViewHolder

class OverviewBookAdapter(private val mDelegate: OverviewBookViewHolderDelegate) : RecyclerView.Adapter<OverviewBookViewHolder>() {
    var booksList:List<BookOverviewVO> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewBookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ebook_main,parent,false)
        return OverviewBookViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: OverviewBookViewHolder, position: Int) {
        if (booksList.isNotEmpty()){
            holder.bindData(booksList[position])
        }
    }

    override fun getItemCount(): Int {
        return booksList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(books:List<BookOverviewVO>){
        this.booksList = books
        notifyDataSetChanged()
    }

}