package com.stratushunter.falcon9.interfaces

import com.stratushunter.falcon9.classes.request.SpaceXQueryBody
import com.stratushunter.falcon9.classes.response.SpaceXResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SpaceXAPIService {

    @POST("launches/query")
    suspend fun launchQuery(@Body body: SpaceXQueryBody): SpaceXResponse
}