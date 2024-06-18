package com.weathercam.module.weather

import com.weathercam.module.cities.CityState

sealed class WeatherState {
    data class Loaded(
        val city: String = "",
        val temperature: Double = 0.0,
        val description: String= "",
        val st :Double = 0.0,
    ): WeatherState()
    data object Loading: WeatherState()
    //data object EmptyWeather: WeatherState()
    data class Error(val message: String): WeatherState()
}