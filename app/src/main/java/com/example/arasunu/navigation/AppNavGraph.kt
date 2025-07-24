package com.example.arasunu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.arasunu.ui.screens.*

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Forecast : Screen("forecast")
    object Settings : Screen("settings")
    object About : Screen("about")
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Forecast.route) { ForecastScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.About.route) { AboutScreen(navController) }
    }
}