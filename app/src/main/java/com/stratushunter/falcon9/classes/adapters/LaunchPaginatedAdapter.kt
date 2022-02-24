package com.stratushunter.falcon9.classes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.stratushunter.falcon9.classes.LaunchItemCallback
import com.stratushunter.falcon9.classes.response.Launch
import com.stratushunter.falcon9.databinding.ViewholderLaunchBinding
import com.stratushunter.falcon9.views.viewholders.LaunchViewHolder

class LaunchPaginatedAdapter : PagingDataAdapter<Launch, LaunchViewHolder>(LaunchItemCallback()) {

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {

        val item = getItem(position) ?: return
        holder.setup(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {

        val binding = ViewholderLaunchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LaunchViewHolder(binding)
    }
}