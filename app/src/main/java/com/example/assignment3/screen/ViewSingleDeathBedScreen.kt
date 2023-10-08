package com.example.assignment3.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlinwithcompose.screens.LocalDeathBeds

/**
 * A screen that views a single death bed in more details
 */
@Composable
fun ViewSingleDeathBedScreen(id: String) {
    val deathBeds = LocalDeathBeds.current
    val deathBed = deathBeds.find { it.id == id }

    Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("")
  
    }
}