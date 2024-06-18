package com.weathercam.module.weather

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.weathercam.repository.RepositoryApi
import com.weathercam.router.NavigationRoutes

@Composable
fun WeatherPage(
    navHostController: NavHostController,
    lat : Float,
    lon : Float
) {

    val weatherViewModel : WeatherViewModel = viewModel(
        factory = WeatherViewModelFactory(
            irepositorio = RepositoryApi(),
            router = NavigationRoutes(navHostController),
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