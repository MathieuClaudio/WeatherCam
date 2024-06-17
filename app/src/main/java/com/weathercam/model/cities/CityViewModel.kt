package com.weathercam.model.cities

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CityViewModel : ViewModel() {
    var cityStateUI by mutableStateOf<CityState>(CityState.Loaded)

    fun RunCityIntention(intention: CityIntention) {
        when(intention){
            CityIntention.SearchCity -> SearchCityApp()
            CityIntention.ShowCity -> ShowCityApp()
        }
    }

    private fun SearchCityApp() {
        cityStateUI = CityState.Loading
    }
    private fun ShowCityApp() {
        cityStateUI = CityState.Loaded
    }

}