package com.stratushunter.falcon9.viewmodels

import androidx.lifecycle.ViewModel
import com.stratushunter.falcon9.interfaces.Falcon9PaginatedLaunchProvider

class MainViewModel(private val launchProvider: Falcon9PaginatedLaunchProvider) : ViewModel() {

}