package com.weathercam.module.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect

@Composable
fun WeatherView(
    modifier: Modifier = Modifier,
    state: WeatherState,
    runIntention: (WeatherIntention)-> Unit
) {
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        runIntention(WeatherIntention.LoadedWeather)
    }
    Column(modifier = modifier.padding(10.dp)) {

        when(state){
            is WeatherState.Error -> ErrorView(message = state.message)
            is WeatherState.Loaded -> WeatherViewLoaded(
                city = state.city,
                temperature = state.temperature,
                description = state.description,
                st = state.st
            )
            is WeatherState.Loading -> WeatherViewDoSomething()
            is WeatherState.EmptyWeather -> EmptyView()
        }

        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
fun ErrorView(message: String){
    Text(text = message)
}

@Composable
fun EmptyView(){
    Text(text = "Nada por aquí")
}

@Composable
fun WeatherViewLoaded(
    city: String,
    temperature: Double,
    description: String,
    st:Double
) {
    Column {
        Text(text = city, style = MaterialTheme.typography.titleMedium)
        Text(text = "${temperature}°", style = MaterialTheme.typography.titleLarge)
        Text(text = description, style = MaterialTheme.typography.bodyMedium)
        Text(text = "sensacionTermica: ${st}°", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun WeatherViewDoSomething() {
    Text(text = "Weather Working for you!")
}
