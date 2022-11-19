package com.stone.booklibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.data.vo.ShelfVO
import com.stone.booklibrary.fragments.ChooseRecyclerViewListStyle
import com.stone.booklibrary.fragments.ManageBookBottomSheet
import com.stone.booklibrary.fragments.MangeShelvesFragment
import com.stone.booklibrary.mvp.presenter.ShelvesDetailPresenter
import com.stone.booklibrary.mvp.presenter.ShelvesDetailsPresenterImpl
import com.stone.booklibrary.mvp.view.ShelvesDetailView
import com.stone.booklibrary.viewpods.CustomBookViewPod
import com.stone.booklibrary.viewpods.ListStyle
import kotlinx.android.synthetic.main.activity_shelves.*
import kotlinx.android.synthetic.main.activity_shelves.ivBack
import kotlinx.android.synthetic.main.view_pod_custom_book_list.*

class ShelvesActivity : AppCompatActivity() ,ShelvesDetailView{

    private lateinit var mPresenter: ShelvesDetailPresenter
    lateinit var mCustomBookViewPod: CustomBookViewPod
    private var shelfVo:ShelfVO? = null
    companion object {
        const val EXTRA_BOOK = "extra_book"
        fun getIntent(context: Context, shelfVo: ShelfVO): Intent {
            val intent = Intent(context, ShelvesActivity::class.java)
            intent.putExtra(EXTRA_BOOK,shelfVo )
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shelves)

        setUpPresenter()
        setUpViewPods()
        setUpListener()

        shelfVo = intent?.getSerializableExtra(EXTRA_BOOK) as ShelfVO
        shelfVo?.let {
            mPresenter.onUIReady(this,it.shelvesTitle)
            tvTitle.text = it.shelvesTitle
        }

    }

    private fun setUpListener() {
        ivBack.setOnClickListener {
            mPresenter.onClickBack()
        }
        ivMore.setOnClickListener {
            mPresenter.onClickMore()
        }
        editTitle.setOnEditorActionListener { textView, i, keyEvent ->
            if(i== EditorInfo.IME_ACTION_DONE){
                shelfVo?.shelvesTitle = editTitle.text.toString()
                mPresenter.changeShelfTitle(shelfVo)
            }
            hideKeyboard()
            return@setOnEditorActionListener false

        }
        ivCancel.setOnClickListener {
            mPresenter.onClickCancelImg()
        }
    }

    private fun setUpViewPods() {
        mCustomBookViewPod = vpShelves as CustomBookViewPod
        mCustomBookViewPod.setUpViewPods(mPresenter)
        mCustomBookViewPod.setUpBookListRecyclerView(ListStyle.SMALL)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[ShelvesDetailsPresenterImpl::class.java]
        mPresenter.initView(this)
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

    override fun onClickMore() {
        val sheet = MangeShelvesFragment(shelfVo?.shelvesTitle,mPresenter)
        sheet.show(supportFragmentManager,sheet.tag)
    }

    override fun onClickBack() {
        onBackPressed()
    }

    override fun onTapRecyclerViewStyle() {
        val chooseRecyclerViewListStyle = ChooseRecyclerViewListStyle(mPresenter)
        chooseRecyclerViewListStyle.show(supportFragmentManager,chooseRecyclerViewListStyle.tag)
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
    }

    override fun editShelvesName(isEdit: Boolean) {
        if (isEdit) {
            editTitle.setText(tvTitle.text.toString())
            tvTitle.visibility = View.GONE
            editTitle.visibility = View.VISIBLE
        }else{
            tvTitle.text = editTitle.text.toString()
            tvTitle.visibility = View.VISIBLE
            editTitle.visibility = View.GONE

        }
    }

    override fun showError(error: String) {

    }

    override fun showBookBottomSheet(bookVO: BookVO) {
        val sheet = ManageBookBottomSheet(bookVO,mPresenter)
        sheet.show(supportFragmentManager,sheet.tag)
    }
    fun hideKeyboard() {
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