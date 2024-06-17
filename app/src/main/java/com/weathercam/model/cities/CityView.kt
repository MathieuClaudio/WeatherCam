package com.weathercam.model.cities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CityView(
    modifier: Modifier = Modifier,
    state: CityState,
    runIntention: (CityIntention)-> Unit
) {
    Column(modifier = modifier.padding(10.dp)) {

        when(state){
            is CityState.Loaded -> CityViewLoaded()
            is CityState.Loading -> CityViewDoSomething()
        }

        Button(onClick = {
            runIntention(CityIntention.SearchCity)
        }) {
            Text(text = "Searching City")
        }
        Button(onClick = {
            runIntention(CityIntention.ShowCity)
        }) {
            Text(text = "City Loaded OK")
        }
    }
}

@Composable
fun CityViewLoaded() {
    Text(text = "Is City OK!")
}

@Composable
fun CityViewDoSomething() {
    Text(text = "City Working for you!")
}