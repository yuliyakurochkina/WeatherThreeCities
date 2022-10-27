package com.example.weatherthreecities.feature.data

import com.example.weatherthreecities.feature.domain.WeatherModel

interface WeatherRepository {
    suspend fun getWeather(city: String): WeatherModel
}