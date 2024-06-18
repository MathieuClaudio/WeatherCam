package com.weathercam.repository

import com.weathercam.repository.model.CityData
import com.weathercam.repository.model.WeatherData

class RepositoryMock : IRepository {
    override suspend fun findCity(city: String): List<CityData> {
        val cityUshuaia = CityData(
            name = "Ushuaia",
            lat = -54.806115899999995f,
            lon = -68.3184972880496f,
            country = "AR",
            state = "Tierra del Fuego Province"
        )
        val cityTolhuin =CityData(
            name = "Tolhuin",
            lat = -54.5113492f,
            lon = -67.1954004f,
            country = "AR",
            state = "Tierra del Fuego Province"
        )
        val cityMerlo =CityData(
            name = "Villa de Merlo",
            lat = -32.342558f,
            lon = -65.0136903f,
            country = "AR",
            state = "San Luis"
        )
        return listOf(cityUshuaia,cityTolhuin,cityMerlo)
    }

    override suspend fun findWeather(lat: Float, lon: Float): WeatherData {
        TODO("Not yet implemented")
    }

    override suspend fun findForecast(lat: Float, lon: Float): List<WeatherData> {
        TODO("Not yet implemented")
    }

}