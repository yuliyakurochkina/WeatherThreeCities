package com.example.weatherthreecities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.viewModels
import com.example.weatherthreecities.feature.mainscreen.MainScreenViewModel
import com.example.weatherthreecities.feature.mainscreen.UiEvent
import com.example.weatherthreecities.feature.mainscreen.ViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainScreenViewModel by viewModels()
    private val tvTemperature: TextView by lazy { findViewById(R.id.tvTemperature) }
    private val tvWindSpeed: TextView by lazy { findViewById(R.id.tvWindSpeed) }
    private val tvWindDir: TextView by lazy { findViewById(R.id.tvWindDir) }
    private val tvFeels_like: TextView by lazy { findViewById(R.id.tvFeels_like) }
    private val tvHumidity: TextView by lazy { findViewById(R.id.tvHumidity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.viewState.observe(this, ::render)
    }

    private fun render(viewState: ViewState) {
        tvTemperature.text = "Now the temperature is ${viewState.currentList.temperature} C."
        tvWindSpeed.text = "Wind speed is ${viewState.currentList.speed} kph."
        tvWindDir.text = "Wind direction is ${viewState.currentList.wind_dir}."
        tvFeels_like.text = "Feels like ${viewState.currentList.feelslike_C} C."
        tvHumidity.text = "The humidity is ${viewState.currentList.humidity} %."
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.select_moscow ->
                    if (checked) {
                        viewModel.processUiEvent(UiEvent.OnButtonClicked("Moscow"))
                    }
                R.id.select_sochi ->
                    if (checked) {
                        viewModel.processUiEvent(UiEvent.OnButtonClicked("Sochi"))
                    }
                R.id.select_samara ->
                    if (checked) {
                        viewModel.processUiEvent(UiEvent.OnButtonClicked("Samara"))
                    }
            }
        }
    }
}