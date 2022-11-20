package com.stone.booklibrary.viewpods

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.stone.booklibrary.R
import com.stone.booklibrary.adapter.BookCategoryAdapter
import com.stone.booklibrary.adapter.BookListAdapter
import com.stone.booklibrary.adapter.CategoryBookListAdapter
import com.stone.booklibrary.adapter.CategoryBookSmallListAdapter
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.delegate.BookCategoryViewHolderDelegate
import com.stone.booklibrary.delegate.OverviewBookViewHolderDelegate
import kotlinx.android.synthetic.main.view_pod_custom_book_list.view.*

class CustomBookViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {
    lateinit var mBookCategoryAdapter: BookCategoryAdapter
    lateinit var mBookListAdapter: CategoryBookListAdapter
    lateinit var mBookSmallListAdapter: CategoryBookSmallListAdapter
    lateinit var mDelegate: BookCategoryViewHolderDelegate

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    private fun setUpRecyclerView() {
        mBookCategoryAdapter = BookCategoryAdapter(mDelegate)
        rvBookCategory.adapter = mBookCategoryAdapter
        mBookListAdapter = CategoryBookListAdapter(mDelegate)
        mBookSmallListAdapter = CategoryBookSmallListAdapter(mDelegate)

    }

    fun setNewData(books: List<BookVO>) {
        mBookCategoryAdapter.setNewDate(books)
    }

    fun setNewBookData(books: List<BookVO>) {
        mBookListAdapter.setNewData(books)
        mBookSmallListAdapter.setNewData(books)
    }

    fun setUpBookListRecyclerView(listStyle: ListStyle) {
        when (listStyle) {
            ListStyle.LIST -> {
                rvBookList.visibility = View.VISIBLE
                rvBookSmallList.visibility = View.GONE
                rvBookList.adapter = mBookListAdapter
                ivListStyle.setImageResource(R.drawable.ic_list_view_24)
            }
            ListStyle.LARGE -> {
                rvBookList.visibility = View.GONE
                rvBookSmallList.visibility = View.VISIBLE
                rvBookSmallList.layoutManager = GridLayoutManager(context, 2)
                rvBookSmallList.adapter = mBookSmallListAdapter
                ivListStyle.setImageResource(R.drawable.ic_grid_view_24)
            }
            ListStyle.SMALL -> {
                rvBookList.visibility = View.GONE
                rvBookSmallList.visibility = View.VISIBLE
                rvBookSmallList.layoutManager = GridLayoutManager(context, 3)
                rvBookSmallList.adapter = mBookSmallListAdapter
                ivListStyle.setImageResource(R.drawable.ic_grid_view_24)
            }


        }

    }


    fun setUpViewPods(mDelegate: BookCategoryViewHolderDelegate) {
        this.mDelegate = mDelegate
        setUpRecyclerView()
        ivListStyle.setOnClickListener {
            mDelegate.onClickRecyclerViewStyle()
        }
        ivSortList.setOnClickListener {
            mDelegate.onClickSortList()
        }

    }

    fun sortList(sortType: SortType) {
        when(sortType){
            SortType.RECENT -> tvSortType.tvSortType.text = sortType.text
            SortType.TITLE -> tvSortType.tvSortType.text = sortType.text
            SortType.AUTHOR -> tvSortType.tvSortType.text = sortType.text
        }
    }
}

enum class ListStyle {
    LIST,
    LARGE,
    SMALL
}
enum class SortType(val text:String) {
    RECENT(text="Recent Open"),
    TITLE("Title"),
    AUTHOR("Author")
}