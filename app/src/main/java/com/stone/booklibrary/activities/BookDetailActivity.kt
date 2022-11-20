package com.stone.booklibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : AppCompatActivity() {
    companion object{
        private const val BOOK_EXTRA = "book_extra"
        fun getIntent(context: Context,bookVO: BookVO):Intent{
            val intent = Intent(context,BookDetailActivity::class.java)
            intent.putExtra(BOOK_EXTRA,bookVO)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val bookVO = intent?.getSerializableExtra(BOOK_EXTRA) as BookVO
        bookVO.let {
            tvBookAuthor.text = it.author
            tvBookTitle.text = it.title
            Glide.with(this)
                .load(it.bookImage)
                .placeholder(R.drawable.book)
                .into(ivSearchBook)

        }

        ivBack.setOnClickListener {
            onBackPressed()
        }

    }

}