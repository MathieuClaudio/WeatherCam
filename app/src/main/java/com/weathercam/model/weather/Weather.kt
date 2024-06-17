package com.weathercam.model.weather

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Weather(modifier: Modifier = Modifier) {
    val weatherViewModel : WeatherViewModel = viewModel()
    WeatherView(state = weatherViewModel.weatherStateUI) { intention->
        weatherViewModel.RunWeatherIntention(intention)
    }
}