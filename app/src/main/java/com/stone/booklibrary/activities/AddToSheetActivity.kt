package com.stone.booklibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.stone.booklibrary.R
import com.stone.booklibrary.adapter.AddToShelvesAdapter
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.data.vo.ShelfVO
import com.stone.booklibrary.delegate.OnClickCheckBoxDelegate
import com.stone.booklibrary.mvp.presenter.AddToShelvesPresenter
import com.stone.booklibrary.mvp.presenter.AddToShelvesPresenterImpl
import com.stone.booklibrary.mvp.view.AddToShelvesView
import kotlinx.android.synthetic.main.activity_add_to_sheet.*

class AddToSheetActivity : AppCompatActivity() ,AddToShelvesView,OnClickCheckBoxDelegate{

    private lateinit var mPresenter: AddToShelvesPresenter
    private lateinit var mAdapter:AddToShelvesAdapter
    private lateinit var bookVO: BookVO

    companion object{
        const val EXTRA_BOOK = "extra_book"
        fun getIntent(context: Context,bookVO: BookVO):Intent{
            val intent = Intent(context,AddToSheetActivity::class.java)
            intent.putExtra(EXTRA_BOOK,bookVO)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_sheet)

        setUpPresenter()
        setUpRecyclerView()

        bookVO = intent.getSerializableExtra(EXTRA_BOOK) as BookVO


        mPresenter.onUIReady(this)
    }

    private fun setUpRecyclerView() {
        mAdapter = AddToShelvesAdapter(this)
        rvShelves.adapter = mAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[AddToShelvesPresenterImpl::class.java]
        mPresenter.init(this)
    }

    override fun getALLShelves(shelves: List<ShelfVO>) {
        mAdapter.setNewData(shelves)
    }

    override fun onTapCheckBox() {
    }

    override fun showError(error: String) {
    }

    override fun showBookBottomSheet(bookVO: BookVO) {
    }

    override fun onClickCheckBox(shelvesVO: ShelfVO) {

        Toast.makeText(this, bookVO.toString(), Toast.LENGTH_SHORT).show()
        shelvesVO.bookLists?.add(bookVO)
        if(shelvesVO.bookLists == null){
            val books:MutableList<BookVO> = mutableListOf()
            books.add(bookVO)
            shelvesVO.bookLists = books
        }
        mPresenter.onClickCheckBox(shelvesVO)
    }
}