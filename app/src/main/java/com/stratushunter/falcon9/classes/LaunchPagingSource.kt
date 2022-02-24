package com.stratushunter.falcon9.classes

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.stratushunter.falcon9.classes.response.Launch
import com.stratushunter.falcon9.interfaces.Falcon9PaginatedLaunchProvider

class LaunchPagingSource(private val falcon9PaginatedLaunchProvider: Falcon9PaginatedLaunchProvider) : PagingSource<Int, Launch>() {

    private val defaultPage = 1

    //region PagingSource
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Launch> {

        val page = params.key ?: defaultPage

        return try {

            val response = falcon9PaginatedLaunchProvider.fetchFalcon9Launches(page, params.loadSize)
            val launches = response.docs
            LoadResult.Page(
                launches,
                prevKey = if (page == defaultPage) null else page - 1,
                nextKey = if (launches.isEmpty()) null else page + 1)
        }
        catch (exception: Exception) {

            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Launch>): Int? = null
    //endregion
}