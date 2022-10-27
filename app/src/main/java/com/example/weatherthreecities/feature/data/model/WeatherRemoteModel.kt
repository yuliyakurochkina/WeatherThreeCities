package com.example.weatherthreecities.feature.data.model

import com.google.gson.annotations.SerializedName

data class WeatherRemoteModel(
    @SerializedName("current")
    val currentList: WeatherMainRemoteModel
)