package com.example.snapfit.views.authentication.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            println("Username: $username, Password: $password")
        }
    }
}
