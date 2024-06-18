package com.weathercam.module.cities

import com.weathercam.repository.model.CityData

sealed class CityState {
    data object EmptyCity: CityState()
    data object Loading: CityState()
    data class Loaded(val cities: List<CityData>): CityState()
    data class Error(val message: String): CityState()
}