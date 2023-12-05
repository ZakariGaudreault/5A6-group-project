package com.example.snapfit.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * The auth layout of the screen with only a top bar
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