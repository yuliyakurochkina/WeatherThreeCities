package com.example.weatherthreecities.feature.data

import com.example.weatherthreecities.base.Constant.API_KEY
import com.example.weatherthreecities.feature.data.model.WeatherRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("current.json")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("key") apiKey: String = API_KEY
    ): WeatherRemoteModel

}