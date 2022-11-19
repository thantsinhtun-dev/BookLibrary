package com.stone.booklibrary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.stone.booklibrary.R
import com.stone.booklibrary.activities.CreateNewsShelvesActivity
import com.stone.booklibrary.activities.ShelvesActivity
import com.stone.booklibrary.adapter.ShelvesAdapter
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.data.vo.ShelvesVO
import com.stone.booklibrary.mvp.presenter.ShelvesListPresenter
import com.stone.booklibrary.mvp.presenter.ShelvesListPresenterImpl
import com.stone.booklibrary.mvp.view.ShelvesListView
import kotlinx.android.synthetic.main.fragment_your_shelves.*


class YourShelvesFragment : Fragment() ,ShelvesListView{

    private lateinit var mPresenter: ShelvesListPresenter
    private lateinit var mAdapter : ShelvesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_your_shelves, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpPresenter()
        setUpRecyclerView()
        setUpListener()
        mPresenter.onUIReady(this)
    }

    private fun setUpListener() {
        btnCreateNewShelf.setOnClickListener {
            mPresenter.onClickCreateNewShelf()
        }
    }

    private fun setUpRecyclerView() {
        mAdapter = ShelvesAdapter(mPresenter)
        rvShelves.adapter = mAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[ShelvesListPresenterImpl::class.java]
        mPresenter.init(this)
    }

    override fun getAllShelves(shelves: List<ShelvesVO>) {
        mAdapter.setNewData(shelves)
    }

    override fun onTapShelves(shelvesVO: ShelvesVO) {
        startActivity(context?.let { ShelvesActivity.getIntent(it) })
    }

    override fun onTapCreateShelves() {
        startActivity(context?.let { CreateNewsShelvesActivity.getIntent(it) })
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showBookBottomSheet(bookVO: BookVO) {
    }


}