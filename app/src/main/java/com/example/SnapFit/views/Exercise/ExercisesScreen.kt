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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.entities.workout.Workout
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.views.profile.ProfileViewModel
import com.example.snapfit.views.workout.WorkoutViewModel

/**
 * Composable function to display a list of exercises based on the specified type.
 *
 * @param type The type of exercises to display (e.g., "strength", "cardio", "no equipment", "flexibility").
 */
@Composable
fun ExercisesScreen(
    type: String,
    workoutViewModel: WorkoutViewModel,
    profileViewModel: ProfileViewModel,
) {
    val counter by workoutViewModel.toggledCount.collectAsState()
    val profile by profileViewModel.activeProfile.collectAsState()
    val navController = LocalNavController.current

    LaunchedEffect(true) {
        workoutViewModel.resetCounter()
    }
    Column(
        modifier =
            Modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = type,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
        )

        // Ideally, instead of hardcoding, we would have either a local storage, or database online
        val exerciseList =
            when (type) {
                "strength" -> listOf("push up", "burpees", "rest", "crunch", "dumbbell curl")
                "cardio" -> listOf("Jogging", "burpees", "crunch", "starfish")
                "no equipment" -> listOf("push up", "burpees", "rest", "crunch")
                "flexibility" -> listOf("crunch", "cobra stretch", "starfish", "rest")
                else -> listOf("pushup") // failsafe
            }

        val duration: Double =
            when (type) {
                "strength" -> 30.0
                "cardio" -> 20.0
                "no equipment" -> 45.0
                "flexibility" -> 50.0
                else -> 0.0
            }

        exerciseList.forEach { exercise ->
            ExerciseCard(exercise, workoutViewModel::incrementCounter)
        }

        Button(
            onClick = {
                val workout =
                    Workout(
                        profile.email,
                        type,
                        duration,
                        exerciseList,
                    )
                ;workoutViewModel.addWorkout(
                    workout,
                )
                navController.popBackStack()
            },
            modifier = Modifier.padding(horizontal = 125.dp, vertical = 8.dp),
            enabled = counter == exerciseList.size,
        ) {
            Text(text = "Complete")
        }
    }
}