package com.example.snapfit.views.authentication.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {
    private val _usernameState = MutableStateFlow("")
    val usernameState: StateFlow<String> = _usernameState.asStateFlow()

    private val _passwordState = MutableStateFlow("")
    val passwordState: StateFlow<String> = _passwordState.asStateFlow()

    private val _confirmPasswordState = MutableStateFlow("")
    val confirmPasswordState: StateFlow<String> = _confirmPasswordState.asStateFlow()

    private val _weightState = MutableStateFlow("")
    val weightState: StateFlow<String> = _weightState.asStateFlow()

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

    fun setConfirmPassword(confirmPassword: String) {
        _confirmPasswordState.value = confirmPassword
    }

    fun setWeight(weight: String) {
        _weightState.value = weight
    }

    fun signUpUser() {
        val username = usernameState.value
        val password = passwordState.value
        val confirmPassword = confirmPasswordState.value
        val weight = weightState.value

        if (validateUsername(username) && validatePassword(password) && validateConfirmPassword(password, confirmPassword) && validateWeight(weight)) {
            viewModelScope.launch {
                kotlinx.coroutines.delay(1000)
                _navigateToMain.value = true
            }
        } else {
            _errorMessage.value = "Invalid input. Please check your details."
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

    private fun validateConfirmPassword(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }

    private fun validateWeight(weight: String): Boolean {
        // Implement your validation logic for weight
        return weight.isNotBlank()
    }
}