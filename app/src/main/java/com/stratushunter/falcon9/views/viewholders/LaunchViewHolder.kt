package com.stratushunter.falcon9.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.stratushunter.falcon9.classes.response.Launch
import com.stratushunter.falcon9.databinding.ViewholderLaunchBinding
import com.stratushunter.falcon9.interfaces.ImageLoader

class LaunchViewHolder(private val binding: ViewholderLaunchBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setup(launch: Launch, imageLoader: ImageLoader) {

        binding.launch = launch
        imageLoader.loadImage(launch.links.patch.small, binding.imageView)
    }
}