package com.example.weatherthreecities.feature.mainscreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.weatherthreecities.base.BaseViewModel
import com.example.weatherthreecities.base.Event
import com.example.weatherthreecities.feature.domain.WeatherInteractor
import com.example.weatherthreecities.feature.domain.WeatherModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val interactor: WeatherInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadWeather)
    }

    override fun initialViewState() = ViewState(
        city = " ",
        currentList = WeatherModel(
            temperature = " ",
            humidity = " ",
            speed = " ",
            wind_dir = " ",
            feelslike_C =  " "
        ),
        weatherPointsShown = WeatherModel(
            temperature = " ",
            humidity = " ",
            speed = " ",
            wind_dir = " ",
            feelslike_C =  " "
        ),
        hasErrorHappened = false,
        isLoading = false
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnButtonClicked -> {
                viewModelScope.launch {
                    interactor.getWeather(event.city).fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage as String)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnLoadCitiesSucceed(it))
                        }
                    )
                }
                return null
            }

            is DataEvent.OnLoadCitiesSucceed -> {
                return previousState.copy(
                    currentList = event.main,
                    weatherPointsShown = event.main
                )
            }

            is DataEvent.OnLoadCitiesFailed -> {
                return previousState.copy(
                    weatherPointsShown = WeatherModel(
                        temperature = " ",
                        humidity = " ",
                        speed = " ",
                        wind_dir = " ",
                        feelslike_C =  " "
                    ),
                    hasErrorHappened = true
                )
            }
            else -> return null
        }
    }
}
