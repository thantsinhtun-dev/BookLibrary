package com.stone.booklibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.BookVO
import kotlinx.android.synthetic.main.fragment_manage_book_bottomsheet.*

class ManageBookBottomSheet(val bookVO: BookVO): BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manage_book_bottomsheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        setUpListener()
    }

    private fun setUpView() {
        context?.let {
            Glide.with(it)
                .load(bookVO.bookImage)
                .into(ivBook)

            tvBookTitle.text = bookVO.title
            tvBookAuthor.text = bookVO.author
        }

    }

    private fun setUpListener() {
        rlDownload.setOnClickListener {  }
        rlDelete.setOnClickListener { }
        rlMakeRead.setOnClickListener {  }
        rlShelves.setOnClickListener {  }
    }
}