package com.stone.booklibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.stone.booklibrary.R
import com.stone.booklibrary.adapter.BookListAdapter
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.fragments.ManageBookBottomSheet
import com.stone.booklibrary.mvp.presenter.BookListPresenter
import com.stone.booklibrary.mvp.presenter.BookListPresenterImpl
import com.stone.booklibrary.mvp.view.BookListView
import com.stone.booklibrary.network.responses.BookListResult
import kotlinx.android.synthetic.main.activity_book_list.*
import retrofit2.http.FormUrlEncoded

class BookListActivity : AppCompatActivity(),BookListView{

    //presenter
    private lateinit var mPresenter: BookListPresenter
    private lateinit var mBookListAdapter:BookListAdapter

    companion object {

        private const val EXTRA_BOOK_LIST_NAME = "EXTRA_BOOK_LIST_NAME"
        private const val EXTRA_BOOK_LIST_NAME_ENCODED = "EXTRA_BOOK_LIST_NAME_ENCODED"
        fun getIntent(context: Context, bookListName: String,bookListNameEncoded: String): Intent {
            val intent = Intent(context, BookListActivity::class.java)
            intent.putExtra(EXTRA_BOOK_LIST_NAME, bookListName)
            intent.putExtra(EXTRA_BOOK_LIST_NAME_ENCODED,bookListNameEncoded)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        setUpPresenter()
        setUpListener()
        setUpRecyclerView()

        val bookListName = intent?.getStringExtra(EXTRA_BOOK_LIST_NAME)
        bookListName?.let {
            txtBookListTitle.text = it

        }
        val bookListNameEncoded = intent?.getStringExtra(EXTRA_BOOK_LIST_NAME_ENCODED)
        bookListNameEncoded?.let {
            mPresenter.onUIReadyBookList(this,it)
        }


    }

    private fun setUpListener() {
        ivBack.setOnClickListener {
            mPresenter.onTapBack()
        }
    }

    private fun setUpRecyclerView() {
        mBookListAdapter = BookListAdapter(mPresenter)
        rvBookList.adapter = mBookListAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[BookListPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    override fun getAllBooks(books: List<BookListResult>) {
        mBookListAdapter.setNewData(books)
    }

    override fun navigateBack() {
        onBackPressed()
    }

    override fun onTapBook(bookVO: BookVO) {
    }

    override fun addToShelves(bookVO: BookVO) {

    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showBookBottomSheet(bookVO: BookVO) {
        val bottomSheet = ManageBookBottomSheet(bookVO,mPresenter)
        bottomSheet.show(supportFragmentManager,bottomSheet.tag)
    }
}