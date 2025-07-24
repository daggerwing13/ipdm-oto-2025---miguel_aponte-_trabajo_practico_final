package com.example.arasunu.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class WeatherResponse(
    val location: Location,
    val current: Current
)

@Serializable
data class Location(val name: String, val country: String)

@Serializable
data class Current(
    val temperature: Int,

    @SerialName("weather_descriptions")
    val weatherDescriptions: List<String>
)
