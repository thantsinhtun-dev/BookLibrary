package com.stone.booklibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.stone.booklibrary.R
import com.stone.booklibrary.delegate.SortListDelegate
import com.stone.booklibrary.viewpods.SortType
import kotlinx.android.synthetic.main.fragment_choose_list_style.*

class SortListFragment (val mDelegate: SortListDelegate): BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sort_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rdGroup.setOnCheckedChangeListener{ group,checkId->
            when(checkId){
                R.id.rdRecent -> mDelegate.sortList(SortType.RECENT)
                R.id.rdTitle -> mDelegate.sortList(SortType.TITLE)
                R.id.rdAuthor -> mDelegate.sortList(SortType.AUTHOR)
            }
            this.dismiss()
        }
    }
}