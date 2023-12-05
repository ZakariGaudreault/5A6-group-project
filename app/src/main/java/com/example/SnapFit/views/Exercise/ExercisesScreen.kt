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

        if (type == "strength") {
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
        } else if (type == "cardio") {
            ExerciseCard("high heels")
            ExerciseCard("burpees")
            ExerciseCard("crunch")
            ExerciseCard("starfish")
            ExerciseCard("burpees")
            ExerciseCard("high heels")
            ExerciseCard("high heels")
            ExerciseCard("burpees")
        } else if (type == "no equipment") {
            ExerciseCard("push up")
            ExerciseCard("burpees")
            ExerciseCard("rest")
            ExerciseCard("crunch")
            ExerciseCard("push up")
            ExerciseCard("burpees")
            ExerciseCard("push up")
            ExerciseCard("burpees")
        } else if (type == "flexibility") {
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
        } else {
            ExerciseCard("pushup")
            ExerciseCard("pushup")
            ExerciseCard("pushup")
            ExerciseCard("pushup")
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