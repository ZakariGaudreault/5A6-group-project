package com.example.snapfit.screen

import WorkoutCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WorkoutsScreen() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column(
        modifier =
            Modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = "Workouts",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors =
                SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary,
                    inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
            steps = 2,
            valueRange = 15f..60f,
        )
        Text(text = "${sliderPosition.toInt()} minutes")

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(vertical = 10.dp),
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f),
            ) {
                Text("Home")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f),
            ) {
                Text("Gym")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f),
            ) {
                Text("Outdoor")
            }
        }

        WorkoutCard()
        WorkoutCard()
        WorkoutCard()
        WorkoutCard()
    }
}