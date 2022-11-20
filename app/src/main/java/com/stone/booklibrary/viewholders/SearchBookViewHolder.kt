package com.stone.booklibrary.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stone.booklibrary.R
import com.stone.booklibrary.delegate.SearchBookDelegate
import com.stone.booklibrary.network.responses.SearchBookVolumeInfo
import kotlinx.android.synthetic.main.item_search_book.view.*

class SearchBookViewHolder(itemView: View, mDelegate: SearchBookDelegate) :RecyclerView.ViewHolder(itemView) {

    var searchBookVolumeInfo :SearchBookVolumeInfo? = null
    init {
        itemView.setOnClickListener {
            searchBookVolumeInfo?.let { mDelegate.onClickSearchBook(it) }
        }
    }
    fun bindData(bookVO: SearchBookVolumeInfo){
        searchBookVolumeInfo = bookVO
        itemView.tvBookAuthor.text = bookVO.searchBookVO?.author?.get(0) ?: ""
        itemView.tvBookTitle.text = bookVO.searchBookVO?.title
        Glide.with(itemView.context)
            .load(bookVO.searchBookVO?.bookImage?.image)
            .placeholder(R.drawable.book)
            .into(itemView.ivSearchBook)
    }
}