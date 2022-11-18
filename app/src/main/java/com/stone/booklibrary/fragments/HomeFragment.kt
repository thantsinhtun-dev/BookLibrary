package com.stone.booklibrary.fragments

import alirezat775.lib.carouselview.Carousel
import alirezat775.lib.carouselview.CarouselView
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.stone.booklibrary.R
import com.stone.booklibrary.adapter.HomePagerAdapter
import com.stone.booklibrary.adapter.RecentBookAdapter
import com.stone.booklibrary.data.vo.BookVO
import com.stone.booklibrary.mvp.presenter.HomePresenter
import com.stone.booklibrary.mvp.presenter.HomePresenterImpl
import com.stone.booklibrary.mvp.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(),HomeView {

    private lateinit var mRecentBookAdapter:RecentBookAdapter
    private lateinit var carousel: Carousel

    //presenter
    private lateinit var mPresenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecyclerView()
        setUpTapLayout()
        setUpViewPager(EbooksFragment())
        setUpListener()

        mPresenter.onUIReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[HomePresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpListener() {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.tag) {
                    getString(R.string.lbl_ebooks) -> {
                        setUpViewPager(EbooksFragment())
                    }
                    getString(R.string.lbl_audio_books) -> {
                        setUpViewPager(AudioBooksFragment())
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun setUpTapLayout() {
       tabLayout.newTab().apply {
           tag = getString(R.string.lbl_ebooks)
           text = getString(R.string.lbl_ebooks)
           tabLayout.addTab(this)
        }
        tabLayout.newTab().apply {
            tag = getString(R.string.lbl_audio_books)
            text = getString(R.string.lbl_audio_books)
            tabLayout.addTab(this)
        }
    }
    private fun setUpViewPager(fragment: Fragment) {
        val adapter = HomePagerAdapter(this)
        vpHome.isUserInputEnabled = false
        vpHome.adapter = adapter
//        TabLayoutMediator(tabLayout, vpHome) { tab, position ->
//            if (position == 0) {
//                tab.text = getString(R.string.lbl_ebooks)
//            } else {
//                tab.text = getString(R.string.lbl_audio_books)
//            }
//        }.attach()

    }

    private fun setUpRecyclerView() {
        mRecentBookAdapter = RecentBookAdapter()
        carousel = Carousel((activity as AppCompatActivity), rvRecentBook, mRecentBookAdapter)
        carousel.setOrientation(CarouselView.HORIZONTAL, false)
        carousel.scaleView(true)
    }

    override fun getAllRecentBook(books: List<BookVO>) {
        if (books.isEmpty()){
            rvRecentBook.visibility = View.GONE
        }else{
            mRecentBookAdapter.setNewData(books)
            rvRecentBook.visibility = View.VISIBLE
        }

    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }


}