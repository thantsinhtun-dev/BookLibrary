package com.stone.booklibrary.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.stone.booklibrary.R
import com.stone.booklibrary.mvp.presenter.CreateShelvesPresenter
import com.stone.booklibrary.mvp.presenter.CreateShelvesPresenterImpl
import com.stone.booklibrary.mvp.view.CreateShelvesView
import kotlinx.android.synthetic.main.activity_create_news_shelves.*

class CreateNewsShelvesActivity : AppCompatActivity(),CreateShelvesView {
    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context, CreateNewsShelvesActivity::class.java)
        }
    }

    private lateinit var mPresenter: CreateShelvesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_news_shelves)
        setUpPresenter()
        setUpListener()
        mPresenter.onUIReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[CreateShelvesPresenterImpl::class.java]
        mPresenter.init(this)
    }

    private fun setUpListener() {
        editCreateShelf.setOnEditorActionListener { textView, i, keyEvent ->
            if(i==EditorInfo.IME_ACTION_DONE){
                mPresenter.onAddNewShelves(editCreateShelf.text.toString())
            }
            return@setOnEditorActionListener false

        }
    }

    override fun addNewShelves() {
        hideKeyboard()
        onBackPressed()
    }
    fun hideKeyboard() {
        // Check if no view has focus:
        val view = this.currentFocus

        // if nothing is currently
        // focus then this will protect
        // the app from crash

        // if nothing is currently
        // focus then this will protect
        // the app from crash
        if (view != null) {

            // now assign the system
            // service to InputMethodManager
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