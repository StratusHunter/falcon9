package com.stratushunter.falcon9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.stratushunter.falcon9.classes.SpaceXOptions
import com.stratushunter.falcon9.classes.SpaceXQuery
import com.stratushunter.falcon9.classes.SpaceXQueryBody
import com.stratushunter.falcon9.classes.SpaceXResponse
import com.stratushunter.falcon9.enums.Rocket
import com.stratushunter.falcon9.enums.SpaceXSelectOptions
import com.stratushunter.falcon9.interfaces.SpaceXAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v4/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val service = retrofit.create(SpaceXAPIService::class.java)
        val call = service.launchQuery(SpaceXQueryBody(SpaceXQuery(Rocket.FALCON9.identifier), SpaceXOptions(10, SpaceXSelectOptions.values().map { it.value })))
        call.enqueue(object : Callback<SpaceXResponse> {

            override fun onResponse(call: Call<SpaceXResponse>, response: Response<SpaceXResponse>) {
            }

            override fun onFailure(call: Call<SpaceXResponse>, t: Throwable) {
            }
        })
    }
}