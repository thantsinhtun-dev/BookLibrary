package com.stone.booklibrary.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.stone.booklibrary.adapter.BookCategoryAdapter
import com.stone.booklibrary.adapter.BookListAdapter
import com.stone.booklibrary.adapter.CategoryBookListAdapter
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.BookCategoryViewHolderDelegate
import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import kotlinx.android.synthetic.main.view_pod_custom_book_list.view.*

class CustomBookViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context,attrs) {
    lateinit var mBookCategoryAdapter: BookCategoryAdapter
    lateinit var mBookListAdapter: CategoryBookListAdapter
    lateinit var mDelegate: BookCategoryViewHolderDelegate

    init {

    }
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    private fun setUpRecyclerView() {
        mBookCategoryAdapter = BookCategoryAdapter(mDelegate)
        rvBookCategory.adapter = mBookCategoryAdapter
        mBookListAdapter = CategoryBookListAdapter(mDelegate)

    }
    fun setNewData(books: List<BookVO>) {
        mBookCategoryAdapter.setNewDate(books)
    }
    fun setNewBookData(books: List<BookVO>){
        mBookListAdapter.setNewData(books)
    }

    fun setUpBookListRecyclerView(listStyle: ListStyle){
        when(listStyle){
            ListStyle.LIST -> {
                rvBookList.layoutManager = GridLayoutManager(context,2)
                rvBookList.adapter = mBookListAdapter
            }
            ListStyle.LARGE -> {

                rvBookList.layoutManager = GridLayoutManager(context,2)
                rvBookList.adapter = mBookListAdapter
            }
            ListStyle.SMALL -> {

                rvBookList.layoutManager = GridLayoutManager(context,3)
                rvBookList.adapter = mBookListAdapter
            }


        }

    }


    fun setUpViewPods(mDelegate:BookCategoryViewHolderDelegate) {
        this.mDelegate = mDelegate
        setUpRecyclerView()
        ivListStyle.setOnClickListener {
            mDelegate.onClickRecyclerViewStyle()
        }
        ivSortList.setOnClickListener {
            mDelegate.onClickSortList()
        }
    }
}
enum class ListStyle{
    LIST,
    LARGE,
    SMALL
}