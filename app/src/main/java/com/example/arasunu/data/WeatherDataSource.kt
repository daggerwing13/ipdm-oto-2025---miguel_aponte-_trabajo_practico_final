package com.example.arasunu.data

import com.example.arasunu.data.WeatherResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class WeatherDataSource {

    private val apiKey = "c6207259ecdd12a4f5122884aa27ca0d"

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getWeather(city: String): WeatherResponse {
        val url = "http://api.weatherstack.com/current?access_key=$apiKey&query=${city}"
        return client.get(url).body()
    }
}
