package com.example.arasunu.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.arasunu.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Bienvenido/a Arasunu App!", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate(Screen.Forecast.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a Pronóstico")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Screen.Settings.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ajustes")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Screen.About.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Acerca de")
        }
    }
}
