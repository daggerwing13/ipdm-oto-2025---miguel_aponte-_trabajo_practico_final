package com.example.arasunu.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.arasunu.viewmodel.ForecastViewModel

@Composable
fun ForecastScreen(
    navController: NavController,
    viewModel: ForecastViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var city by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Ver Pronóstico", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Ingrese el nombre de la ciudad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.fetchWeather(city) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Pronóstico")
        }

        if (viewModel.isLoading) {
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator()
        }

        Spacer(modifier = Modifier.height(32.dp))

        viewModel.weatherResult?.let {
            Text("Temperatura: ${it.temperature}°C")
            Text("Descripción: ${it.weatherDescriptions}")
        }

        viewModel.errorMessage?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }
    }
}
