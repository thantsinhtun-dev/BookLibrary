package com.stone.booklibrary.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.stone.booklibrary.R
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.fragments.HomeFragment
import com.stone.booklibrary.fragments.LibraryFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        bottomNavi.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.menu_home->
                    setCurrentFragment(HomeFragment())
                R.id.menu_library->
                    setCurrentFragment(LibraryFragment())
            }
            true
        }
        bottomNavi.selectedItemId = R.id.menu_home

        AppModelImpl.getOverviewBook(
            onSuccess = {
                Log.i("success","success")
            },
            onFailure = {
                Log.i("success",it)
            }
        )
        edSearch.setOnClickListener {
            startActivity(SearchBookActivity.getIntent(context = this))
        }
    }

    private fun setCurrentFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }
    }

}