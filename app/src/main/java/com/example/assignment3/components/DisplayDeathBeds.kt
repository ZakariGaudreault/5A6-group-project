package com.example.assignment3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.assignment3.navigation.Routes
import com.example.compose.md_theme_light_primary
import com.example.compose.md_theme_light_secondaryContainer
import com.example.kotlinwithcompose.screens.LocalDeathBeds
import com.example.kotlinwithcompose.screens.LocalNavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

/**
 * DisplayDeathBeds composable is used to display a list of of the people on the death note list
 *
 */
@Composable
fun DisplayDeathBeds() {
    val deathBeds = LocalDeathBeds.current
    val navController = LocalNavController.current

    LazyColumn {
        items(deathBeds) { deathBed ->

            // Clickable column to go into a specific death bed
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(
                        color = md_theme_light_secondaryContainer,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp)
                    .clickable {
                        navController.navigate(Routes.SingleDeathBed.go(deathBed.id))
                    }, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Name of the victim: ${deathBed.fullName}",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(4.dp),
                )

                // Button that "executes"/deletes the deathbed.
                Button(onClick = { deathBeds.remove(deathBed) }) {
                    Text("Execute")
                }
            }
        }

    }
}

