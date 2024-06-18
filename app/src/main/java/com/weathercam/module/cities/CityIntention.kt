package com.weathercam.module.cities

import com.weathercam.repository.model.CityData

sealed class CityIntention {
    data class SearchCity( val cityName:String ): CityIntention()
    data class ShowCity(val city: CityData): CityIntention()
}