package com.example.weatherthreecities.feature.data

import com.example.weatherthreecities.feature.domain.WeatherModel
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val source: WeatherRemoteSource
) : WeatherRepository {

    override suspend fun getWeather(city: String): WeatherModel {
        return source.getWeather(city).toDomain()
    }

}
