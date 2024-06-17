package com.weathercam.model.cities

sealed class CityIntention {
    data object SearchCity: CityIntention()
    data object ShowCity: CityIntention()
}