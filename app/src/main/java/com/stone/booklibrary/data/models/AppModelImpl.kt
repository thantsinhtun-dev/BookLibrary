package com.stone.booklibrary.data.models

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import com.stone.booklibrary.data.vo.BookOverviewVO
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.network.responses.BookListResult
import com.stone.booklibrary.utils.PARAM_LIST_NAME
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object AppModelImpl : BaseModel(), AppModel {
    override fun getOverviewBook(
        onSuccess: (List<BookOverviewVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

            mApiService.getOverviewBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    it.result.bookList?.let { bookList ->
                        onSuccess(bookList)
                    }
                },{
                    onFailure(it.localizedMessage ?: "")
                })

    }

    override fun getAllRecentBook(onFailure: (String) -> Unit): LiveData<List<BookVO>>? {
      return  mBooksDatabase?.recentBookDao()?.getAllBooks()
    }

    override fun setRecentBook(bookVO: BookVO) {
        mBooksDatabase?.recentBookDao()?.insertSingleBook(bookVO)
    }

    override fun getBookList(
        bookListName: String,
        onSuccess: (List<BookListResult>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        val map = HashMap<String,String>()
        map[PARAM_LIST_NAME] = bookListName
        mApiService.getBookList(listName = bookListName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                Log.i("GooModel", it.result?.get(0)?.listName.toString() ?: "Zero")
                it.result?.let { it1 -> onSuccess(it1) }
            },{
                onFailure(it.localizedMessage ?: "")
            })

    }

}