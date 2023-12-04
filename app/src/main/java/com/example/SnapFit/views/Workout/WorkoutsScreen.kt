package com.example.snapfit.views.workout

import WorkoutCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.R

@Composable
fun WorkoutsScreen() {
    var homeworkout by rememberSaveable { mutableStateOf(true) }
    var gymworkout by rememberSaveable { mutableStateOf(true) }
    var outdoorworkout by rememberSaveable { mutableStateOf(true) }
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    val backgroundColorHome = if (homeworkout) colorResource(R.color.purple_500) else colorResource(R.color.purple_200)
    val backgroundColorGym = if (gymworkout) colorResource(R.color.purple_500) else colorResource(R.color.purple_200)
    val backgroundColorOutdoor = if (outdoorworkout) colorResource(R.color.purple_500) else colorResource(R.color.purple_200)

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
            modifier = Modifier.padding(vertical = 10.dp).padding(horizontal = 42.dp),

        ) {
            Button(
                onClick = { homeworkout = !homeworkout },
                colors = buttonColors(backgroundColorHome)
            ) {
                Text("Home")
            }
            Button(
                onClick = { gymworkout = !gymworkout },
                colors = buttonColors(backgroundColorGym)
            ) {
                Text("Gym")
            }
            Button(
                onClick = { outdoorworkout = !outdoorworkout },
                colors = buttonColors(backgroundColorOutdoor)
            ) {
                Text("Outdoor")
            }
        }


        WorkoutCard("cardio")
        WorkoutCard("strength")

        if(homeworkout) {
            WorkoutCard("no equipment")
        }

        if(sliderPosition.toInt() > 45)
        WorkoutCard("flexibility")
    }
}