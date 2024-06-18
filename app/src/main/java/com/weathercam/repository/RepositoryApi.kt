package com.weathercam.repository

import com.weathercam.repository.model.CityData
import com.weathercam.repository.model.WeatherData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class RepositoryApi : IRepository {

    private val apiKey = "e419cbf98fb0d4f6923ad994750fc086"

    private val client = HttpClient(){
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun findCity(city: String): List<CityData> {
        val response = client.get("https://api.openweathermap.org/geo/1.0/direct"){
            parameter("q",city)
            parameter("limit",15)
            parameter("appid",apiKey)
        }

        if (response.status == HttpStatusCode.OK){
            val citiesList = response.body<List<CityData>>()
            return citiesList
        }else{
            throw Exception()
        }
    }

    override suspend fun findWeather(lat: Float, lon: Float): WeatherData {
        val response = client.get("https://api.openweathermap.org/data/2.5/weather"){
            parameter("lat",lat)
            parameter("lon",lon)
            parameter("lang","es")
            parameter("units","metric")
            parameter("appid",apiKey)
        }
        if (response.status == HttpStatusCode.OK){
            val clima = response.body<WeatherData>()
            return clima
        }else{
            throw Exception()
        }
    }

    override suspend fun findForecast(lat: Float, lon: Float): List<WeatherData> {
        TODO("Not yet implemented")
    }

}