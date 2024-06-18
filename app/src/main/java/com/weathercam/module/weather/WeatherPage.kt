package com.weathercam.module.weather

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.weathercam.repository.RepositoryApi
import com.weathercam.router.Navigation

@Composable
fun WeatherPage(
    navHostController: NavHostController,
    lat : Float,
    lon : Float
) {

    val weatherViewModel : WeatherViewModel = viewModel(
        factory = WeatherViewModelFactory(
            repositorio = RepositoryApi(),
            router = Navigation(navHostController),
            lat = lat,
            lon = lon
        )
    )
    WeatherView(
        state = weatherViewModel.weatherStateUI,
        runIntention = { intention ->
            weatherViewModel.runWeatherIntention(intention)
        }
    )

}