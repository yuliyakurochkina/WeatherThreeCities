package com.example.weatherthreecities.feature.data.model

import com.google.gson.annotations.SerializedName

data class WeatherMainRemoteModel(
    @SerializedName("temp_c")
    val temperature: String,
    @SerializedName("humidity")
    val humidity: String,
    @SerializedName("wind_kph")
    val speed: String,
    @SerializedName("wind_dir")
    val wind_dir: String,
    @SerializedName("feelslike_c")
    val feelslike_C: String,
)