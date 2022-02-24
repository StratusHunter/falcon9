package com.stratushunter.falcon9.classes.falcon9paginatedlaunchprovider

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.stratushunter.falcon9.classes.request.SpaceXOptions
import com.stratushunter.falcon9.classes.request.SpaceXQuery
import com.stratushunter.falcon9.classes.request.SpaceXQueryBody
import com.stratushunter.falcon9.classes.response.SpaceXResponse
import com.stratushunter.falcon9.constants.Config
import com.stratushunter.falcon9.enums.Rocket
import com.stratushunter.falcon9.enums.SpaceXSelectOptions
import com.stratushunter.falcon9.interfaces.Falcon9PaginatedLaunchProvider
import com.stratushunter.falcon9.interfaces.SpaceXAPIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFalcon9PaginatedLaunchProvider(baseURL: String = Config.baseURL) : Falcon9PaginatedLaunchProvider {

    private val service: SpaceXAPIService

    init {

        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        service = retrofit.create(SpaceXAPIService::class.java)
    }

    //region Falcon9PaginatedLaunchProvider
    override suspend fun fetchFalcon9Launches(page: Int, size: Int): SpaceXResponse {

        val query = SpaceXQuery(Rocket.FALCON9.identifier)
        val options = SpaceXOptions(page, size, SpaceXSelectOptions.values().map { it.value })
        val body = SpaceXQueryBody(query, options)
        return service.launchQuery(body)
    }
    //endregion
}