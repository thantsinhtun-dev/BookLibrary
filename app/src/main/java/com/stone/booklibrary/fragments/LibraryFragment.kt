package com.stone.booklibrary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.stone.booklibrary.R
import com.stone.booklibrary.adapter.LibraryPagerAdapter
import kotlinx.android.synthetic.main.fragment_library.tabLayout
import kotlinx.android.synthetic.main.fragment_library.vpHome


class LibraryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpTapLayout()
        setUpViewPager(YourBookFragment())
    }

    private fun setUpViewPager(fragment: Fragment) {
        val adapter = LibraryPagerAdapter(this)
        vpHome.adapter = adapter
        vpHome.isUserInputEnabled = false
        TabLayoutMediator(tabLayout, vpHome) { tab, position ->
            if (position == 0) {
                tab.text = getString(R.string.lbl_your_books)
            } else {
                tab.text = getString(R.string.lbl_your_shelves)
            }
        }.attach()
    }

    private fun setUpTapLayout() {
        tabLayout.newTab().apply {
            tag = getString(R.string.lbl_your_books)
            text = getString(R.string.lbl_your_books)
            tabLayout.addTab(this)
        }
        tabLayout.newTab().apply {
            tag = getString(R.string.lbl_your_shelves)
            text = getString(R.string.lbl_your_shelves)
            tabLayout.addTab(this)
        }
    }


}