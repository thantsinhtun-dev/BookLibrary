package com.stone.booklibrary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.stone.booklibrary.R
import com.stone.booklibrary.activities.AddToSheetActivity
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.mvp.presenter.YourBookPresenter
import com.stone.booklibrary.mvp.presenter.YourBookPresenterImpl
import com.stone.booklibrary.mvp.view.YourBookView
import com.stone.booklibrary.viewpods.CustomBookViewPod
import com.stone.booklibrary.viewpods.ListStyle
import kotlinx.android.synthetic.main.fragment_your_book.*
import kotlinx.android.synthetic.main.view_pod_custom_book_list.*


class YourBookFragment : Fragment(),YourBookView {

    private lateinit var mPresenter: YourBookPresenter

    lateinit var mCustomBookViewPod: CustomBookViewPod
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_your_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpPresenter()
        setUpViewPods()
        setUpListener()
        mPresenter.onUIReady(this)
    }

    private fun setUpListener() {
        ivCancel.setOnClickListener {
            mPresenter.onClickCancelImg()
        }

    }

    private fun setUpViewPods() {
        mCustomBookViewPod = vpYourBook as CustomBookViewPod
        mCustomBookViewPod.setUpViewPods(mPresenter)
        mCustomBookViewPod.setUpBookListRecyclerView(ListStyle.SMALL)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[YourBookPresenterImpl::class.java]
        mPresenter.init(this)
    }

    override fun getAllBooks(books: List<BookVO>) {
        mCustomBookViewPod.setNewData(books)
        mCustomBookViewPod.setNewBookData(books)
    }

    override fun onClickBookCategory(bookVO: List<BookVO>) {
        ivCancel.visibility = View.VISIBLE
        mCustomBookViewPod.setNewData(bookVO)
    }

    override fun onClickCancelImage() {
        ivCancel.visibility = View.GONE
    }

    override fun onTapRecyclerViewStyle() {
        val chooseRecyclerViewListStyle = ChooseRecyclerViewListStyle(mPresenter)
        chooseRecyclerViewListStyle.show(childFragmentManager,chooseRecyclerViewListStyle.tag)
    }

    override fun onTapSortList() {
    }

    override fun changeRecyclerViewStyle(listStyle: ListStyle) {
        mCustomBookViewPod.setUpBookListRecyclerView(listStyle)
    }

    override fun rebuildList(books: List<BookVO>) {
        mCustomBookViewPod.setNewBookData(books)
    }

    override fun addToShelves(bookVO: BookVO) {
        startActivity(context?.let { AddToSheetActivity.getIntent(it,bookVO) })
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showBookBottomSheet(bookVO: BookVO) {
        val sheet = ManageBookBottomSheet(bookVO,mPresenter)
        sheet.show(childFragmentManager,sheet.tag)
    }


}