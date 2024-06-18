package com.weathercam.module.weather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.weathercam.repository.IRepository
import com.weathercam.router.Router
import kotlinx.coroutines.launch

class WeatherViewModel(
    val respositorio: IRepository,
    val router: Router,
    val lat : Float,
    val lon : Float
) : ViewModel() {
    var weatherStateUI by mutableStateOf<WeatherState>(WeatherState.Loading)

    fun runWeatherIntention(intention: WeatherIntention) {
        when(intention){
            WeatherIntention.LoadedWeather -> LoadWeatherApp()
        }
    }

    private fun LoadWeatherApp() {
        weatherStateUI = WeatherState.Loading
        viewModelScope.launch {
            try{
                val weatherCity = respositorio.findWeather(lat = lat, lon = lon)
                weatherStateUI = WeatherState.Loaded(
                    city = weatherCity.name ,
                    temperature = weatherCity.main.temp,
                    description = weatherCity.weather.first().description,
                    st = weatherCity.main.feels_like,
                    humidity = weatherCity.main.humidity,
                    icon = weatherCity.weather.first().icon,
                    country = weatherCity.sys.country
                )
            } catch (exception: Exception){
                weatherStateUI = WeatherState.Error(exception.localizedMessage ?: "Error!")
            }
        }
    }

}

class WeatherViewModelFactory(
    private val irepositorio: IRepository,
    private val router: Router,
    private val lat: Float,
    private val lon: Float,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(irepositorio,router,lat,lon) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}