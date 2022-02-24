package com.stratushunter.falcon9.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.stratushunter.falcon9.classes.response.Launch
import com.stratushunter.falcon9.databinding.ViewholderLaunchBinding

class LaunchViewHolder(private val binding: ViewholderLaunchBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setup(launch: Launch) {

        binding.launch = launch
    }
}