package com.stratushunter.falcon9.interfaces

import com.stratushunter.falcon9.classes.SpaceXQueryBody
import com.stratushunter.falcon9.classes.SpaceXResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SpaceXAPIService {

    @POST("launches/query")
    suspend fun launchQuery(@Body body: SpaceXQueryBody): SpaceXResponse
}