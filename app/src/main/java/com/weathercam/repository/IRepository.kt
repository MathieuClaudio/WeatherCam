package com.weathercam.repository

import com.weathercam.repository.model.CityData
import com.weathercam.repository.model.WeatherData

interface IRepository {
    suspend fun findCity(city: String): List<CityData>
    suspend fun findWeather(lat: Float, lon: Float): WeatherData
    suspend fun findForecast(lat: Float, lon: Float): List<WeatherData>
}