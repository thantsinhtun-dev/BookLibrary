package com.stone.booklibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.stone.booklibrary.R
import com.stone.booklibrary.adapter.SearchBookAdapter
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.mvp.presenter.SearchBookMainPresenter
import com.stone.booklibrary.mvp.presenter.SearchBookMainPresenterImpl
import com.stone.booklibrary.mvp.view.SearchBookView
import com.stone.booklibrary.network.responses.SearchBookVolumeInfo
import kotlinx.android.synthetic.main.activity_search_movie.*

class SearchBookActivity : AppCompatActivity() ,SearchBookView{

    private lateinit var mPresenter: SearchBookMainPresenter
    private lateinit var mAdapter: SearchBookAdapter
    companion object{
        fun getIntent(context:Context): Intent {
            return Intent(context,SearchBookActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)

        edSearch.requestFocus()

        setUpPresenter()
        setUpListener()


        setUpTapLayout()
        setUpViewPager()
        setUpRecyclerView()

        mPresenter.onUIReady(this)

    }

    private fun setUpRecyclerView() {
        mAdapter = SearchBookAdapter(mPresenter)
        rvSearch.adapter = mAdapter
    }

    private fun setUpListener() {
        edSearch.setOnEditorActionListener { textView, i, keyEvent ->
            if(i== EditorInfo.IME_ACTION_DONE){
                mPresenter.onSearchBook(edSearch.text.toString())
            }
            hideKeyboard()
            return@setOnEditorActionListener false

        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[SearchBookMainPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpViewPager() {


    }

    private fun setUpTapLayout() {
        tabLayout.newTab().apply {
            tag = getString(R.string.lbl_ebooks)
            text = getString(R.string.lbl_audio_books)
            tabLayout.addTab(this)
        }
        tabLayout.newTab().apply {
            tag = getString(R.string.lbl_ebooks)
            text = getString(R.string.lbl_audio_books)
            tabLayout.addTab(this)
        }
    }

    override fun showSearchBookList(books: List<SearchBookVolumeInfo>) {
        mAdapter.setNewData(books)
    }

    override fun onTapBack() {
        onBackPressed()
    }

    override fun navigateToBookDetail(bookVO: BookVO) {
        startActivity(BookDetailActivity.getIntent(this,bookVO))
    }

    override fun showError(error: String) {

        Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun showBookBottomSheet(bookVO: BookVO) {
    }

    private fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val manager = getSystemService(
                INPUT_METHOD_SERVICE
            ) as InputMethodManager
            manager
                .hideSoftInputFromWindow(
                    view.windowToken, 0
                )
        }
    }
}