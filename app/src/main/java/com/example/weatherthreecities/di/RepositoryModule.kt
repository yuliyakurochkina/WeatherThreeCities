package com.example.weatherthreecities.di

import com.example.weatherthreecities.feature.data.WeatherRemoteSource
import com.example.weatherthreecities.feature.data.WeatherRepository
import com.example.weatherthreecities.feature.data.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(
        remoteSource: WeatherRemoteSource
    ): WeatherRepository {
        return WeatherRepositoryImpl(remoteSource)
    }
}