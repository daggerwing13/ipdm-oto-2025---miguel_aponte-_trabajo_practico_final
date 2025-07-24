package com.example.arasunu.data.repository

import com.example.arasunu.data.WeatherResponse
import com.example.arasunu.data.WeatherDataSource

class WeatherRepository(private val dataSource: WeatherDataSource) {
    suspend fun getWeather(city: String): Result<WeatherResponse> {
        return try {
            Result.success(dataSource.getWeather(city))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
