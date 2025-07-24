package com.example.arasunu.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var username by mutableStateOf("")
        private set

    var error by mutableStateOf("")
        private set

    fun onUsernameChanged(newName: String) {
        username = newName
        error = ""
    }

    fun onLoginClick(navigateToHome: () -> Unit) {
        if (username.isBlank()) {
            error = "Usuario requerido!"
        } else {
            navigateToHome()
        }
    }
}