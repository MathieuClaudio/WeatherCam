package com.weathercam.model.cities

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun City(modifier: Modifier = Modifier) {
    val cityViewModel : CityViewModel = viewModel()
    CityView(state = cityViewModel.cityStateUI) { intention->
        cityViewModel.RunCityIntention(intention)
    }
}