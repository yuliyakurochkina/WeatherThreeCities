package com.example.weatherthreecities.feature.domain

data class WeatherModel(
    val temperature: String,
    val humidity: String,
    val speed: String,
    val wind_dir: String,
    val feelslike_C: String
)