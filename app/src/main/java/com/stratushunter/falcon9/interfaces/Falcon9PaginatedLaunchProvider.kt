package com.stratushunter.falcon9.interfaces

import com.stratushunter.falcon9.classes.response.SpaceXResponse

interface Falcon9PaginatedLaunchProvider {

    suspend fun fetchFalcon9Launches(page: Int, size: Int): SpaceXResponse
}