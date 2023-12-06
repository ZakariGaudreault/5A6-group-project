package com.example.snapfit.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * This layout provides a common structure for authentication screens, such as login and signup.
 *
 * @param content The content of the authentication screen, specified as a composable lambda.
 * It represents the body of the authentication screen
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthLayout(content: @Composable () -> Unit) {
    Scaffold(
    ) {
        Column(modifier = Modifier.padding(it)) {
            content()
        }
    }
}