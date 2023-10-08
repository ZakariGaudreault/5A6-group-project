package com.example.assignment3.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.assignment3.components.DisplayDeathBeds
import com.example.assignment3.rememberMutableStateListOf

/**
 * The main screen of the app, which displays the list of all the potential deathbeds
 */
@Composable
fun MainScreen() {
    DisplayDeathBeds()
}
