package com.example.weatherthreecities.feature.domain

import com.example.weatherthreecities.base.attempt
import com.example.weatherthreecities.feature.data.WeatherRepository
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend fun getWeather(city: String) = attempt { repository.getWeather(city) }
}