package com.weathercam.module.cities

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.weathercam.repository.IRepository
import com.weathercam.repository.model.CityData
import com.weathercam.router.Router
import com.weathercam.router.Routes
import kotlinx.coroutines.launch

class CityViewModel(
    val irepository: IRepository,
    val router: Router
) : ViewModel() {
    var cityStateUI by mutableStateOf<CityState>(CityState.EmptyCity)
    var cities : List<CityData> = emptyList()

    fun runCityIntention(intention: CityIntention) {
        when(intention){
            is CityIntention.SearchCity -> SearchCityApp(name = intention.cityName)
            is CityIntention.ShowCity -> ShowCityApp(city = intention.city)
        }
    }

    private fun SearchCityApp(name: String) {
        cityStateUI = CityState.Loading

        viewModelScope.launch {
            try {
                cities = irepository.findCity(name)
                cityStateUI = CityState.Loaded(cities)
            } catch (exeption: Exception){
                cityStateUI = CityState.Error(exeption.message ?: "Error!")
            }
        }

    }
    private fun ShowCityApp(city: CityData) {
        val route = Routes.WheatherRouter(
            lat = city.lat,
            lon = city.lon
        )
        router.navigateTo(route)
    }

    class CitiesViewModelFactory(
        private val irepository: IRepository,
        private val router: Router
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CityViewModel::class.java)) {
                return CityViewModel(irepository,router) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}