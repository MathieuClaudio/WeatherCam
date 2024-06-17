package com.weathercam

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.weathercam.ui.theme.WeatherCamTheme

@Composable
fun MainApp(modifier: Modifier = Modifier) {
    Text(
        text = "Hello weather CAM",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainAppPreview() {
    WeatherCamTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainApp()
        }
    }
}