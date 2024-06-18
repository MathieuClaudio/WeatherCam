package com.weathercam.module.cities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.weathercam.repository.model.CityData

@Composable
fun CityView(
    modifier: Modifier = Modifier,
    state: CityState,
    runIntention: (CityIntention)-> Unit
) {
    var value by remember{ mutableStateOf("") }

    Column(modifier = modifier) {
        TextField(
            value = value,
            label = { Text(text = "Buscar por nombre de ciudad") },
            onValueChange = {
                value = it
                runIntention(CityIntention.SearchCity(value))
            },
        )
        when(state) {
            CityState.Loading -> Text(text = "Cargando")
            is CityState.Error -> Text(text = state.message)
            is CityState.Loaded -> ListCity(state.cities) {
                runIntention(
                    CityIntention.ShowCity(it)
                )
            }
            CityState.EmptyCity -> Text(text = "Sin Resultados!")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListCity(cities: List<CityData>, onSelect: (CityData)->Unit) {
    LazyColumn {
        items(items = cities) {
            Card(onClick = { onSelect(it) }) {
                Text(text = it.name)
            }
        }
    }
}