package com.stratushunter.falcon9.interfaces

import com.stratushunter.falcon9.classes.Launch
import com.stratushunter.falcon9.classes.SpaceXQueryBody
import com.stratushunter.falcon9.classes.SpaceXResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SpaceXAPIService {

    @POST("launches/query")
    fun launchQuery(@Body body: SpaceXQueryBody): Call<SpaceXResponse>
}