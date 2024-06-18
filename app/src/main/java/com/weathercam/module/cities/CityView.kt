package com.weathercam.module.cities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.weathercam.R
import com.weathercam.repository.model.CityData
import java.util.Locale

@Composable
fun CityView(
    modifier: Modifier = Modifier,
    state: CityState,
    runIntention: (CityIntention)-> Unit
) {
    var value by remember{ mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = value,
            label = { Text(text = "Buscar por nombre de ciudad") },
            onValueChange = {
                value = it
                runIntention(CityIntention.SearchCity(value))
            },
        )
        when(state) {
            CityState.Loading -> {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.loading_gif)
                        .build(),
                    contentDescription = "Loading",
                    modifier = Modifier.size(50.dp)
                )
            }
            is CityState.Error -> Text(text = state.message)
            is CityState.Loaded -> ListCity(state.cities) {
                runIntention(
                    CityIntention.ShowCity(it)
                )
            }
            CityState.EmptyCity -> Text(text = "Sin Resultados!", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListCity(cities: List<CityData>, onSelect: (CityData) -> Unit) {
    LazyColumn {
        items(items = cities) { city ->
            Card(
                onClick = { onSelect(city) },
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.padding(3.dp)
            ) {
                Column(modifier = Modifier.padding(5.dp)) {
                    val locale = Locale("", city.country)
                    val countryName = locale.displayCountry

                    Text(
                        text = "${city.name} - $countryName",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}