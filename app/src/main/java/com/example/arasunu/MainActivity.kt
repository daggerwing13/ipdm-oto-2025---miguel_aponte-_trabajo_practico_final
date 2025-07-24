package com.example.arasunu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.arasunu.navigation.AppNavGraph
import com.example.arasunu.ui.theme.ArasunuTheme
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArasunuTheme {
                AppNavGraph(navController = rememberNavController())
            }
        }
    }
}
