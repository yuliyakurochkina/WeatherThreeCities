package com.example.weatherthreecities.feature.data

import com.example.weatherthreecities.feature.data.model.WeatherRemoteModel
import javax.inject.Inject

class WeatherRemoteSource @Inject constructor(
    private val api: WeatherApi
) {

    suspend fun getWeather(city: String): WeatherRemoteModel {
        return api.getWeather(city)
    }

}
