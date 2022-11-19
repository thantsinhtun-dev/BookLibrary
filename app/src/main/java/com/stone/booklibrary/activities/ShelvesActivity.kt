package com.stone.booklibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stone.booklibrary.R

class ShelvesActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context,ShelvesActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shelves)
    }
}