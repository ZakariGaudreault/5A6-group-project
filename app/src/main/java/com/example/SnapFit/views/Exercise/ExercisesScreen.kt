package com.example.snapfit.views.exercise

import ExerciseCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.ui.theme.md_theme_light_primary

@Composable
fun ExercisesScreen() {
    Column(
        modifier =
            Modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
    ) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Yoga",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "4 exercises",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Completed",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.background(color = md_theme_light_primary),
            )
        }

        ExerciseCard()
        ExerciseCard()
        ExerciseCard()
        ExerciseCard()
    }
}