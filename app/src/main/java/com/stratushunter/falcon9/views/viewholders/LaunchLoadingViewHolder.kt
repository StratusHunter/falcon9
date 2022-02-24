package com.stratushunter.falcon9.views.viewholders

import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.stratushunter.falcon9.databinding.ViewholderLaunchLoadingBinding

class LaunchLoadingViewHolder(private val binding: ViewholderLaunchLoadingBinding, retry: () -> Unit) : RecyclerView.ViewHolder(binding.root) {

    init {

        binding.retryButton.setOnClickListener { retry() }
    }

    fun setup(loadState: LoadState) = with(binding) {

        progressBar.isVisible = loadState is LoadState.Loading
        retryButton.isVisible = loadState is LoadState.Error
    }
}