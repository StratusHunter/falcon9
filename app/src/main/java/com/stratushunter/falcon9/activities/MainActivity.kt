package com.stratushunter.falcon9.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.stratushunter.falcon9.classes.adapters.LaunchLoadStateAdapter
import com.stratushunter.falcon9.classes.adapters.LaunchPaginatedAdapter
import com.stratushunter.falcon9.classes.imageloader.GlideImageLoader
import com.stratushunter.falcon9.databinding.ActivityMainBinding
import com.stratushunter.falcon9.viewmodels.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var adapter : LaunchPaginatedAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = LaunchPaginatedAdapter(GlideImageLoader(this))

        binding.recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LaunchLoadStateAdapter(adapter::retry),
            footer = LaunchLoadStateAdapter(adapter::retry))

        binding.retryButton.setOnClickListener { adapter.retry() }

        bindDataToViews()
    }

    private fun bindDataToViews() {

        lifecycleScope.launch {

            adapter.loadStateFlow.collectLatest {

                val refresh = it.refresh
                binding.progressBar.isVisible = refresh is LoadState.Loading
                binding.retryButton.isVisible = refresh is LoadState.Error
            }
        }

        lifecycleScope.launch {

            viewModel.paginatedLaunchesFlow
                .distinctUntilChanged()
                .collectLatest { adapter.submitData(it) }
        }
    }
}