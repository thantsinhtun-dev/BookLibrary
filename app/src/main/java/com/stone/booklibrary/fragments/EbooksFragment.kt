package com.stone.booklibrary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.stone.booklibrary.R
import com.stone.booklibrary.activities.BookListActivity
import com.stone.booklibrary.adapter.OverviewBookAdapter
import com.stone.booklibrary.data.vo.BookOverviewVO
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.mvp.presenter.EBookPresenter
import com.stone.booklibrary.mvp.presenter.EBookPresenterImpl
import com.stone.booklibrary.mvp.view.EBookView
import kotlinx.android.synthetic.main.fragment_ebook.*


class EbooksFragment : Fragment(), EBookView {

    //presenter
    private lateinit var mPresenter: EBookPresenter
    private lateinit var mEBookAdapter: OverviewBookAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ebook, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUIReady(this)
    }

    private fun setUpRecyclerView() {
        mEBookAdapter = OverviewBookAdapter(mPresenter)
        rvBookMain.adapter = mEBookAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[EBookPresenterImpl::class.java]
        mPresenter.initView(this)
    }


    override fun getAllOverViewBook(overviewBookList: List<BookOverviewVO>) {
        mEBookAdapter.setNewData(overviewBookList)
    }

    override fun navigateToBookDetail(bookVO: BookVO) {

    }

    override fun navigateToBookList(bookListTile: String, bookListTileEncoded: String) {
        startActivity(context?.let { BookListActivity.getIntent(it,bookListTile,bookListTileEncoded) })
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showBookBottomSheet(bookVO: BookVO) {
        val bottomSheet = ManageBookBottomSheet(bookVO)
        bottomSheet.show(childFragmentManager,bottomSheet.tag)
    }


}