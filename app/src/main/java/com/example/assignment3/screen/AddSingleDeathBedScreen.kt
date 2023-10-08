package com.example.assignment3.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.assignment3.components.FormInput

/**
 * The screen that is used to add a deathbed, containing a form inside to enter the data
 */
@Composable
fun AddSingleDeathBedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormInput()
    }
}