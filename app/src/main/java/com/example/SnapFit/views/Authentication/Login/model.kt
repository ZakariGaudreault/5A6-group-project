package com.example.snapfit.views.authentication.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {
    private val _usernameState = MutableStateFlow("")
    val usernameState: StateFlow<String> = _usernameState.asStateFlow()

    private val _passwordState = MutableStateFlow("")
    val passwordState: StateFlow<String> = _passwordState.asStateFlow()

    private val _navigateToMain = MutableStateFlow(false)
    val navigateToMain: StateFlow<Boolean> = _navigateToMain.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    fun setUsername(username: String) {
        _usernameState.value = username
    }

    fun setPassword(password: String) {
        _passwordState.value = password
    }

    fun loginUser() {
        val username = usernameState.value
        val password = passwordState.value

        if (validateUsername(username) && validatePassword(password)) {
            viewModelScope.launch {
                kotlinx.coroutines.delay(1000)
                _navigateToMain.value = true
            }
        } else {
            _errorMessage.value = "Invalid username or password please choose a username with less than 26 characters" +
                " and a password with more than 6 characters"
        }
    }

    fun setNavigateToMain(value: Boolean) {
        _navigateToMain.value = value
    }

    private fun validateUsername(username: String): Boolean {
        return username.isNotBlank() && username.length <= 25
    }

    private fun validatePassword(password: String): Boolean {
        return password.length >= 6
    }
}