package com.example.weatherthreecities.feature.data

import com.example.weatherthreecities.feature.data.model.WeatherRemoteModel
import com.example.weatherthreecities.feature.domain.WeatherModel

fun WeatherRemoteModel.toDomain() = WeatherModel(
    temperature = this.currentList.temperature,
    humidity = this.currentList.humidity,
    speed = this.currentList.speed,
    wind_dir = this.currentList.wind_dir,
    feelslike_C = this.currentList.feelslike_C
)


