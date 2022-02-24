package com.stratushunter.falcon9.classes

import androidx.recyclerview.widget.DiffUtil
import com.stratushunter.falcon9.classes.response.Launch

class LaunchItemCallback : DiffUtil.ItemCallback<Launch>() {

    //region DiffUtil.ItemCallback
    override fun areItemsTheSame(oldItem: Launch, newItem: Launch) = (oldItem == newItem)

    override fun areContentsTheSame(oldItem: Launch, newItem: Launch) = (oldItem == newItem)
    //endregion
}