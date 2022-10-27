package com.example.weatherthreecities.feature.mainscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherthreecities.R
import com.example.weatherthreecities.feature.domain.WeatherModel

class WeatherAdapter(
    private val OnWeatherPointClicked: (WeatherModel) -> Unit,
) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    private var weatherData: List<WeatherModel> = emptyList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTemp: TextView = view.findViewById(R.id.tvTemp)
        val tvTempMin: TextView = view.findViewById(R.id.tvTempMin)
        val tvTempMax: TextView = view.findViewById(R.id.tvTempMax)
        val tvPressure: TextView = view.findViewById(R.id.tvPressure)
        val tvHumidity: TextView = view.findViewById(R.id.tvHumidity)
    }

    // Создание новых представлений (вызывается менеджером layout)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Создать новое представление, определяющее пользовательский интерфейс элемента списка
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_weather, viewGroup, false)
        return ViewHolder(view)
    }

    // Заменить содержимое представления (вызывается менеджером layout)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.itemView.setOnClickListener {
            OnWeatherPointClicked.invoke(weatherData[position])
        }

        // Получить элемент из набора данных в этой позиции и заменить
        // содержимое представления с этим элементом
        viewHolder.tvTemp.text = weatherData[position].temperature
//        viewHolder.tvTempMin.text = weatherData[position].temp_min
//        viewHolder.tvTempMax.text = weatherData[position].temp_max
//        viewHolder.tvPressure.text = weatherData[position].pressure
        viewHolder.tvHumidity.text = weatherData[position].humidity
    }

    // Вернуть размер набора данных (вызывается менеджером layout)
    override fun getItemCount() = weatherData.size

    fun setData(weatherPoints: WeatherModel) {
        weatherData = listOf(weatherPoints)
        notifyDataSetChanged()
    }
}