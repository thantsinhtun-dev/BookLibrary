package com.stone.booklibrary.mvp.presenter

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.data.vo.BookOverviewVO
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.mvp.view.EBookView

class EBookPresenterImpl : ViewModel(), EBookPresenter {

    private var mView: EBookView? = null
    private var mAppModel: AppModel = AppModelImpl

    override fun initView(view: EBookView) {
        mView = view
    }

    override fun onUIReady(owner: LifecycleOwner) {
//        mAppModel.getOverviewBook(
//            onSuccess = {
////               Log.i("GooData",it[0].toString())
////                Log.i("GooData",it[1].toString())
//                Log.i("GooData",it[2].toString())
//                mView?.getAllOverViewBook(it)
//                    },
//            onFailure = {
//                mView?.showError(it)
//            }
//        )


        val book1 = BookVO(
            id = 0,
            author = "Colleen Hoover",
            title = "IT STARTS WITH US",
            bookImage = "https://storage.googleapis.com/du-prd/books/images/9781668001226.jpg",
            contributor = "by Colleen Hoover",
            createdDate = null,
            description = "In the sequel to “It Ends With Us,” Lily deals with her jealous ex-husband as she reconnects with her first boyfriend.",
            listName = null,
            selected = false,
            index = 0
        )
        val book2 = BookVO(
            id = 0,
            author = "Brandon Sanderson",
            title = "THE LOST METAL",
            bookImage = "https://storage.googleapis.com/du-prd/books/images/9780765391193.jpg",
            contributor = "by Brandon Sanderson",
            createdDate = null,
            description = "The seventh book in the Mistborn series. The fate of millions depends on a decision by the frontier lawman turned big-city senator Waxillium Ladrian.",
            listName = null,
            selected = false,
            index = 0
        );
        val book3 = BookVO(
            id = 0,
            author = "Colleen Hoover",
            title = "IT ENDS WITH US",
            bookImage = "https://storage.googleapis.com/du-prd/books/images/9781501110375.jpg",
            contributor = "by Colleen Hoover",
            createdDate = null,
            description = "A battered wife raised in a violent home attempts to halt the cycle of abuse.",
            listName = null,
            selected = false,
            index = 0
        )
        val book4 = BookVO(
            id = 0,
            author = "Nicholas Sparks",
            title = "DREAMLAND",
            bookImage = "https://storage.googleapis.com/du-prd/books/images/9780593449554.jpg",
            contributor = "by Nicholas Sparks",
            createdDate = null,
            description = "Musicians from different backgrounds are attracted to each other and a mother flees with her son from an abusive husband.",
            listName = null,
            selected = false,
            index = 0
        )
        val book5 = BookVO(
            id = 0,
            author = "John Grisham",
            title = "THE BOYS FROM BILOXI",
            bookImage = "https://storage.googleapis.com/du-prd/books/images/9780385548922.jpg",
            contributor = "by John Grisham",
            createdDate = null,
            description = "Two childhood friends follow in their fathers’ footsteps, which puts them on opposite sides of the law.",
            listName = null,
            selected = false,
            index = 0
        )
        val book6 = BookVO(
            id = 0,
            author = "Colleen Hoover",
            title = "VERITY",
            bookImage = "https://storage.googleapis.com/du-prd/books/images/9781791392796.jpg",
            contributor = "by Colleen Hoover",
            createdDate = null,
            description = "Lowen Ashleigh is hired by the husband of an injured writer to complete her popular series and uncovers a horrifying truth.",
            listName = null,
            selected = false,
            index = 0
        )
        val book7 = BookVO(
            id = 0,
            author = "John Grisham",
            title = "THE BOYS FROM BILOXI",
            bookImage = "https://storage.googleapis.com/du-prd/books/images/9780385548922.jpg",
            contributor = "by John Grisham",
            createdDate = null,
            description = "Two childhood friends follow in their fathers’ footsteps, which puts them on opposite sides of the law.",
            listName = null,
            selected = false,
            index = 0
        )
        val book8 = BookVO(
            id = 0,
            author = "Stephen King",
            title = "FAIRY TALE",
            bookImage = "https://storage.googleapis.com/du-prd/books/images/9781668002179.jpg",
            contributor = "by Stephen King",
            createdDate = null,
            description = "A high school kid inherits a shed that is a portal to another world where good and evil are at war.",
            listName = null,
            selected = false,
            index = 0
        )
        val book9 = BookVO(
            id = 0,
            author = "Michael Connelly",
            title = "DESERT STAR",
            bookImage = "https://storage.googleapis.com/du-prd/books/images/9780316485654.jpg",
            contributor = "by Michael Connelly",
            createdDate = null,
            description = "Ballard and Bosch bury old resentments as they go after two killers.",
            listName = null,
            selected = false,
            index = 0
        )
        val bookOverviewVO1 = BookOverviewVO(
            0,
            "Combined Print and E-Book Fiction",
            "combined-print-and-e-book-fiction",
            bookList = listOf(book1, book2, book3)
        )
        val bookOverviewVO2 = BookOverviewVO(
            0,
            "Combined Print and E-Book Nonfiction",
            "combined-print-and-e-book-nonfiction",
            bookList = listOf(book4, book5, book6)
        )
        val bookOverviewVO3 = BookOverviewVO(
            0,
            "Hardcover Fiction",
            "hardcover-fiction",
            bookList = listOf(book7, book8, book9)
        )

        mView?.getAllOverViewBook(arrayListOf(bookOverviewVO1, bookOverviewVO2, bookOverviewVO3))
    }

    override fun onClickBook(bookVO: BookVO) {
        mView?.navigateToBookDetail(bookVO)
        mAppModel.setRecentBook(bookVO)
    }

    override fun onClickBookList(bookListName: String, encodedName: String) {
        mView?.navigateToBookList(bookListName, encodedName)
    }

    override fun onClickBookMore(bookVO: BookVO) {
        mView?.showBookBottomSheet(bookVO)
    }

    override fun onClickAddToShelves(bookVO: BookVO) {
        mView?.addToShelves(bookVO)
    }
}