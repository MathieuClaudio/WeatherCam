package com.weathercam.router

import android.annotation.SuppressLint
import androidx.navigation.NavHostController

class Navigation(
    val navHostController: NavHostController
): Router {
    @SuppressLint("DefaultLocale")
    override fun navigateTo(ruta: Routes) {
        when(ruta){
            Routes.CitiesRoutes -> navHostController.navigate(ruta.id)

            is Routes.WheatherRouter -> {
                val route = String.format(format="%s?lat=%f&lon=%f",ruta.id,ruta.lat,ruta.lon)
                navHostController.navigate(route)
            }
        }
    }
}