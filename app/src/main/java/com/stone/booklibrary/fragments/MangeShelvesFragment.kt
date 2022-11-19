package com.stone.booklibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.ShelfVO
import com.stone.booklibrary.delegate.ManagementShelfDelegate
import kotlinx.android.synthetic.main.fragment_mangement_shelves.*

class MangeShelvesFragment(private val shelfVO: String?, val mDelegate:ManagementShelfDelegate): BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mangement_shelves, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
    }

    private fun setUpListener() {
        rlEdit.setOnClickListener {
            mDelegate.onClickEdit()
            dismiss()
        }
        rlDelete.setOnClickListener {
            shelfVO?.let { it1 -> mDelegate.onClickDelete(it1) }
            dismiss()
        }

    }

}