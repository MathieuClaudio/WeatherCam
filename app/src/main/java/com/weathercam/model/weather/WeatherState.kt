package com.weathercam.model.weather

sealed class WeatherState {
    object Loading: WeatherState()
    object Loaded: WeatherState()
}