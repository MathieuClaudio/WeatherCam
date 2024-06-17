package com.weathercam.model.weather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WeatherViewModel : ViewModel() {
    var weatherStateUI by mutableStateOf<WeatherState>(WeatherState.Loaded)

    fun RunWeatherIntention(intention: WeatherIntention) {
        when(intention){
            WeatherIntention.LoadingWeather -> LoadingWeatherApp()
            WeatherIntention.LoadedWeather -> LoadWeatherApp()
        }
    }

    private fun LoadingWeatherApp() {
        weatherStateUI = WeatherState.Loading
    }
    private fun LoadWeatherApp() {
        weatherStateUI = WeatherState.Loaded
    }

}