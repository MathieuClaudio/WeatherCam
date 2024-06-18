package com.weathercam

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.weathercam.module.cities.CityPage
import com.weathercam.module.weather.WeatherPage
import com.weathercam.router.Routes


@Composable
fun MainApp(){
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = Routes.CitiesRoutes.id
    ) {
        composable(
            route = Routes.CitiesRoutes.id
        ) {
            CityPage(navHostController)
        }
        composable(
            route = "clima?lat={lat}&lon={lon}",
            arguments =  listOf(
                navArgument("lat") { type= NavType.FloatType },
                navArgument("lon") { type= NavType.FloatType }
            )
        ) {
            val lat = it.arguments?.getFloat("lat") ?: 0.0f
            val lon = it.arguments?.getFloat("lon") ?: 0.0f
            WeatherPage(navHostController, lat = lat, lon = lon)
        }
    }
}

