package com.example.arasunu.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arasunu.data.WeatherDataSource
import com.example.arasunu.data.repository.WeatherRepository
import kotlinx.coroutines.launch

data class SimpleWeather(
    val temperature: Int,
    val weatherDescriptions: String
)

class ForecastViewModel : ViewModel() {

    private val repository = WeatherRepository(WeatherDataSource())

    var weatherResult by mutableStateOf<SimpleWeather?>(null)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set


    fun fetchWeather(city: String) {
        if (city.isBlank()) {
            errorMessage = "Favor ingresar una ciudad"
            weatherResult = null
            return
        }

        errorMessage = null
        weatherResult = null
        isLoading = true


        viewModelScope.launch {
            val result = repository.getWeather(city)
            isLoading = false

            result.onSuccess { data ->
                weatherResult = SimpleWeather(
                    temperature = data.current.temperature,
                    weatherDescriptions = data.current.weatherDescriptions.firstOrNull() ?: "Sin información"
                )
            }.onFailure { error ->
                errorMessage = "Error al cargar pronóstico: ${error.message}"
            }
        }
    }
}
