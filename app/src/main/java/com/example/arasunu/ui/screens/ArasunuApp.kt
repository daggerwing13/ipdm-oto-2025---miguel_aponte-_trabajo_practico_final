package com.example.arasunu.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.arasunu.navigation.AppNavGraph

@Composable
fun ArasunuApp() {
    val navController = rememberNavController()
    AppNavGraph(navController = navController)
}
