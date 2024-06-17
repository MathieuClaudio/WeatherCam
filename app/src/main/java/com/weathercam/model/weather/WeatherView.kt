package com.weathercam.model.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherView(
    modifier: Modifier = Modifier,
    state: WeatherState,
    runIntention: (WeatherIntention)-> Unit
) {
    Column(modifier = modifier.padding(10.dp)) {

        when(state){
            is WeatherState.Loaded -> WeatherViewLoaded()
            is WeatherState.Loading -> WeatherViewDoSomething()
        }

        Button(onClick = {
            runIntention(WeatherIntention.LoadingWeather)
        }) {
            Text(text = "Loading Weather")
        }
        Button(onClick = {
            runIntention(WeatherIntention.LoadedWeather)
        }) {
            Text(text = "Weather Loaded OK")
        }
    }
}

@Composable
fun WeatherViewLoaded() {
    Text(text = "Is Weather OK!")
}

@Composable
fun WeatherViewDoSomething() {
    Text(text = "Weather Working for you!")
}
