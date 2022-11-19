package com.stone.booklibrary.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.stone.booklibrary.fragments.SearchAudioBookFragment
import com.stone.booklibrary.fragments.SearchBookFragment

class SearchPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            SearchBookFragment()
        } else {
            SearchAudioBookFragment()
        }
    }
}