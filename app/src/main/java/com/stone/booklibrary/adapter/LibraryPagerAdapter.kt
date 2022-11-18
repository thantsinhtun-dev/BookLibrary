package com.stone.booklibrary.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.stone.booklibrary.fragments.YourBookFragment
import com.stone.booklibrary.fragments.YourShelvesFragment


class LibraryPagerAdapter(fragmentActivity: Fragment): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            YourBookFragment()
        } else {
            YourShelvesFragment()
        }
    }
}