package com.stratushunter.falcon9.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.stratushunter.falcon9.classes.LaunchPagingSource
import com.stratushunter.falcon9.classes.falcon9paginatedlaunchprovider.RetrofitFalcon9PaginatedLaunchProvider
import com.stratushunter.falcon9.constants.Config
import com.stratushunter.falcon9.interfaces.Falcon9PaginatedLaunchProvider

class MainViewModel(
    launchProvider: Falcon9PaginatedLaunchProvider = RetrofitFalcon9PaginatedLaunchProvider(),
    pageSize: Int = Config.pageSize) : ViewModel() {

    val paginatedLaunchesFlow = Pager(PagingConfig(pageSize)) { LaunchPagingSource(launchProvider) }
        .flow
        .cachedIn(viewModelScope)
}