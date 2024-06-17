package com.weathercam.model.weather

sealed class WeatherIntention {
    data object LoadingWeather: WeatherIntention()
    data object LoadedWeather: WeatherIntention()
}