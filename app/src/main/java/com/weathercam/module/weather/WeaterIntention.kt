package com.weathercam.module.weather

sealed class WeatherIntention {
    data object LoadedWeather: WeatherIntention()
}