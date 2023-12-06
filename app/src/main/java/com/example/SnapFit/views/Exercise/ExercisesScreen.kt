package com.example.snapfit.views.exercise

import ExerciseCard
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Shows all the exercises of a specific workout filled with exercise card
 */

/**
 * Composable function to display a list of exercises based on the specified type.
 *
 * @param type The type of exercises to display (e.g., "strength", "cardio", "no equipment", "flexibility").
 */
@Composable
fun ExercisesScreen(type: String) {
    Column(
        modifier =
            Modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
    ) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = type,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        // Display exercises based on the specified type
        when (type) {
            "strength" -> {
                ExerciseCard("push up")
                ExerciseCard("burpees")
                ExerciseCard("rest")
                ExerciseCard("crunch")
                ExerciseCard(type = "dumbbell curl")
                ExerciseCard("push up")
                ExerciseCard("burpees")
                ExerciseCard("rest")
                ExerciseCard("crunch")
                ExerciseCard(type = "dumbbell curl")
                ExerciseCard("push up")
                ExerciseCard("burpees")
                ExerciseCard("rest")
                ExerciseCard("crunch")
                ExerciseCard(type = "dumbbell curl")
            }
            "cardio" -> {
                ExerciseCard("Jogging")
                ExerciseCard("burpees")
                ExerciseCard("crunch")
                ExerciseCard("starfish")
                ExerciseCard("burpees")
                ExerciseCard("Jogging")
                ExerciseCard("burpees")
            }
            "no equipment" -> {
                ExerciseCard("push up")
                ExerciseCard("burpees")
                ExerciseCard("rest")
                ExerciseCard("crunch")
                ExerciseCard("push up")
                ExerciseCard("burpees")
                ExerciseCard("push up")
                ExerciseCard("burpees")
            }
            "flexibility" -> {
                ExerciseCard("crunch")
                ExerciseCard("cobra stretch")
                ExerciseCard("starfish")
                ExerciseCard("rest")
                ExerciseCard("crunch")
                ExerciseCard("cobra stretch")
                ExerciseCard("starfish")
                ExerciseCard("rest")
                ExerciseCard("crunch")
                ExerciseCard("cobra stretch")
                ExerciseCard("starfish")
                ExerciseCard("rest")
            }
            else -> {
                ExerciseCard("pushup")
                ExerciseCard("pushup")
                ExerciseCard("pushup")
                ExerciseCard("pushup")
            }
        }

        Button(
            onClick = { /* Handle button click here */ },
            modifier =
                Modifier
                    .padding(horizontal = 125.dp),
        ) {
            Text(text = "Completed")
        }
    }
}