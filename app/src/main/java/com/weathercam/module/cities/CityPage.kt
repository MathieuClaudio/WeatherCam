package com.weathercam.module.cities

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.weathercam.repository.RepositoryApi
import com.weathercam.router.NavigationRoutes

@Composable
fun CityPage(
    navHostController: NavHostController
) {
    val cityViewModel : CityViewModel = viewModel(
        factory = CityViewModel.CitiesViewModelFactory(
            irepository = RepositoryApi(),
            router = NavigationRoutes(navHostController)
        )
    )
    CityView(
        state = cityViewModel.cityStateUI,
        runIntention = { intencion ->
            cityViewModel.runCityIntention(intencion)
        }
    )
}
