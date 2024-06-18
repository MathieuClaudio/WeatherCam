package com.weathercam.router

sealed class Routes(val id: String) {

    data object CitiesRoutes: Routes("cityPage")
    data class WheatherRouter(val lat: Float, val lon:Float): Routes("wheatherPage")

}