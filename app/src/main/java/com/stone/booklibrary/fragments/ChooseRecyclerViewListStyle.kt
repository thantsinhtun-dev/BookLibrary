package com.stone.booklibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.stone.booklibrary.R
import com.stone.booklibrary.delegate.ChooseRecyclerViewStyleDelegate
import com.stone.booklibrary.viewpods.ListStyle
import kotlinx.android.synthetic.main.fragment_choose_list_style.*

class ChooseRecyclerViewListStyle(val mDelegate: ChooseRecyclerViewStyleDelegate):BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_list_style, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rdGroup.setOnCheckedChangeListener{ group,checkId->
            when(checkId){
                R.id.rdList -> mDelegate.chooseListStyle(ListStyle.LIST)
                R.id.rdLarge -> mDelegate.chooseListStyle(ListStyle.LARGE)
                R.id.rdSmall -> mDelegate.chooseListStyle(ListStyle.SMALL)
            }
            this.dismiss()
        }
    }
}