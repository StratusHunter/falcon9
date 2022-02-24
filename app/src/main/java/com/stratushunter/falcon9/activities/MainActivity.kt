package com.stratushunter.falcon9.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.stratushunter.falcon9.classes.adapters.LaunchPaginatedAdapter
import com.stratushunter.falcon9.databinding.ActivityMainBinding
import com.stratushunter.falcon9.viewmodels.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val adapter = LaunchPaginatedAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setupViews()
        bindDataToViews()
    }

    private fun setupViews() {

        ActivityMainBinding.inflate(layoutInflater).apply {

            setContentView(root)
            recyclerView.adapter = adapter
        }
    }

    private fun bindDataToViews() {

        lifecycleScope.launch {

            viewModel.paginatedLaunchesFlow
                .distinctUntilChanged()
                .collectLatest { adapter.submitData(it) }
        }
    }
}