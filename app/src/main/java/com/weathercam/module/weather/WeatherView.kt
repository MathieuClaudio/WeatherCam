package com.weathercam.module.weather

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.weathercam.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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
            //is WeatherState.EmptyWeather -> EmptyView()
            is WeatherState.Error -> ErrorView(message = state.message)
            is WeatherState.Loaded -> WeatherViewLoaded(
                city = state.city,
                temperature = state.temperature,
                description = state.description,
                st = state.st,
                humidity = state.humidity
            )
            is WeatherState.Loading -> WeatherViewDoSomething()
        }

        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
fun ErrorView(message: String){
    Text(text = message)
}

//@Composable
//fun EmptyView(){
//    Text(text = "Nada por aquí")
//}

@Composable
fun WeatherViewLoaded(
    modifier: Modifier = Modifier,
    city: String,
    temperature: Double,
    description: String,
    st: Double,
    humidity: Long
) {
    val iconCode = "10d"
    val iconUrl = "https://openweathermap.org/img/wn/$iconCode@2x.png"
    val currentTime = remember { System.currentTimeMillis() } // Obtener hora actual
    val formattedTime = remember(currentTime) { // Formatear hora
        SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date(currentTime))
    }

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.padding(16.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = formattedTime,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = city,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "${temperature}°",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(iconUrl)
                        .crossfade(true) // Efecto de fundido
                        .build(),
                    contentDescription = "Weather Icon",
                    modifier = Modifier.size(70.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = description, style = MaterialTheme.typography.titleMedium)
            }
            Text(
                text = "Sensación Térmica: ${st}°",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Humedad: ${humidity}°",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun WeatherViewDoSomething() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.loading_gif)
                .build(),
            contentDescription = "Loading",
            modifier = Modifier.size(50.dp)
        )
    }
}
