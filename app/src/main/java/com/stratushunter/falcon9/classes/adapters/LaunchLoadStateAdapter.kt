package com.stratushunter.falcon9.classes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.stratushunter.falcon9.databinding.ViewholderLaunchLoadingBinding
import com.stratushunter.falcon9.views.viewholders.LaunchLoadingViewHolder

class LaunchLoadStateAdapter(private val retry: () -> Unit) : LoadStateAdapter<LaunchLoadingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LaunchLoadingViewHolder {

        val binding = ViewholderLaunchLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LaunchLoadingViewHolder(binding, retry)
    }

    override fun onBindViewHolder(holder: LaunchLoadingViewHolder, loadState: LoadState) = holder.setup(loadState)
}