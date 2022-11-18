package com.stone.booklibrary.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stone.booklibrary.adapter.BookAdapter
import com.stone.booklibrary.data.vo.BookOverviewVO
import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import kotlinx.android.synthetic.main.item_ebook_main.view.*

class OverviewBookViewHolder(itemView: View, mDelegate: OverviewBookViewHolderDelegate) :RecyclerView.ViewHolder(itemView) {
    private var mBookAdapter:BookAdapter = BookAdapter(mDelegate)
    private  var mBookVO:BookOverviewVO? =null
    init {
        itemView.txtEbookGroupName.setOnClickListener {
            mBookVO?.let { book -> mDelegate.onClickBookList(book.displayName,book.listNameEncoded) }
        }
        itemView.ivNext.setOnClickListener {
            mBookVO?.let { book -> mDelegate.onClickBookList(book.displayName,book.listNameEncoded) }
        }

    }
    fun bindData(bookOverviewVO: BookOverviewVO) {
        mBookVO = bookOverviewVO
        itemView.txtEbookGroupName.text = bookOverviewVO.displayName
        itemView.rvEbookGroup.adapter = mBookAdapter
        mBookAdapter.setNewData(bookOverviewVO.bookList,mBookVO?.displayName ?:"")
    }
}