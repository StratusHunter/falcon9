package com.stratushunter.falcon9.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stratushunter.falcon9.R
import com.stratushunter.falcon9.classes.falcon9paginatedlaunchprovider.RetrofitFalcon9PaginatedLaunchProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = RetrofitFalcon9PaginatedLaunchProvider()

        lifecycleScope.launch {
            val response = provider.fetchFalcon9Launches(1, 10)
            response.docs
        }
    }
}