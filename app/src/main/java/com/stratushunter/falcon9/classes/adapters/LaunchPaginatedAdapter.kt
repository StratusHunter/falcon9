package com.stratushunter.falcon9.classes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stratushunter.falcon9.classes.LaunchItemCallback
import com.stratushunter.falcon9.classes.response.Launch
import com.stratushunter.falcon9.databinding.ViewholderLaunchBinding
import com.stratushunter.falcon9.views.viewholders.LaunchViewHolder

class LaunchPaginatedAdapter : PagingDataAdapter<Launch, RecyclerView.ViewHolder>(LaunchItemCallback()) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = getItem(position) ?: return
        (holder as? LaunchViewHolder)?.setup(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = ViewholderLaunchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LaunchViewHolder(binding)
    }
}