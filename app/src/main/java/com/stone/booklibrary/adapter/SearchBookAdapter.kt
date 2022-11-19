package com.stone.booklibrary.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.booklibrary.R
import com.stone.booklibrary.network.responses.SearchBookVolumeInfo
import com.stone.booklibrary.viewholders.SearchBookViewHolder

class SearchBookAdapter : RecyclerView.Adapter<SearchBookViewHolder>() {
    private var bookVolume: List<SearchBookVolumeInfo> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBookViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_book, parent, false)
        return SearchBookViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchBookViewHolder, position: Int) {
        if (bookVolume.isNotEmpty()) {
            holder.bindData(bookVolume[position])
        }
    }

    override fun getItemCount(): Int {
        return bookVolume.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(bookList: List<SearchBookVolumeInfo>) {
        bookVolume = bookList
        notifyDataSetChanged()
    }
}