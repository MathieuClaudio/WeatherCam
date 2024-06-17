package com.weathercam.model.cities

sealed class CityState {
    object Loading: CityState()
    object Loaded: CityState()
}