package com.weathercam.repository.model

import kotlinx.serialization.Serializable

@Serializable
data class CityData (
    var name: String,
    var lat: Float,
    var lon: Float,
    var country: String,
    var state: String? = null
)