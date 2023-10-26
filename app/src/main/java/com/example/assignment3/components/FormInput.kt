package com.example.assignment3.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.assignment3.navigation.Routes
import com.example.compose.md_theme_light_primary
import com.example.compose.md_theme_light_secondaryContainer
import com.example.kotlinwithcompose.screens.LocalDeathBeds
import com.example.kotlinwithcompose.screens.LocalNavController

/**
 * Input field composable that accepts a name of a victim to be added to the deathbed. There
 * is also a list of deaths that have been pre generated where the user can choose from.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput() {
    val deathBeds = LocalDeathBeds.current
    val navController = LocalNavController.current
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    // Default type of death, will be randomized for each. Doesn't matter since the user will still change it
    var causeOfDeath by rememberSaveable { mutableStateOf(CAUSES_OF_DEATH.random()) }

    // Modifier used for the selected column, to provide a visual of it.
    val selectedModifier: Modifier =
        Modifier
            .padding(5.dp)
            .border(
                BorderStroke(
                    2.dp,
                    color = md_theme_light_secondaryContainer,
                ),
                shape = RoundedCornerShape(8.dp),
            )
            .padding(5.dp)

    LazyColumn(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Item containing the input fields for the first and last name of the user.
        item {
            TextField(
                value = firstName,
                placeholder = { Text("Victim's first name", textAlign = TextAlign.Center) },
                onValueChange = { firstName = it },
                shape = RoundedCornerShape(8.dp),
            )
            Spacer(
                modifier =
                    Modifier
                        .height(20.dp)
                        .width(20.dp),
            )
            TextField(
                value = lastName,
                placeholder = { Text("Victim's last name", textAlign = TextAlign.Center) },
                onValueChange = { lastName = it },
                shape = RoundedCornerShape(8.dp),
            )
            Spacer(
                modifier =
                    Modifier
                        .height(20.dp)
                        .width(20.dp),
            )
        }

        // The visual list of the causes of death. Each one of them is clickable to select them. A visual
        // change will happen to show that it has been selected
        item {
            LazyRow(modifier = Modifier.padding(5.dp)) {
                items(CAUSES_OF_DEATH) { item ->
                    Column(
                        // Conditional modifier
                        modifier =
                            if (item.name == causeOfDeath.name) {
                                selectedModifier
                            } else {
                                Modifier
                                    .padding(5.dp)
                                    .border(
                                        BorderStroke(
                                            2.dp,
                                            color = md_theme_light_primary,
                                        ),
                                        shape = RoundedCornerShape(8.dp),
                                    )
                            }
                                .padding(5.dp)
                                .clickable { causeOfDeath = item },
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(text = item.name)
                        Image(
                            painterResource(id = item.image),
                            contentDescription = item.name,
                            modifier = Modifier.size(100.dp),
                        )
                    }
                }
            }
        }

        // Item containing the button that will submit the form
        item {
            Spacer(
                modifier =
                    Modifier
                        .height(20.dp)
                        .width(20.dp),
            )
            // A button that only activates if all the fields have been filled
            Button(onClick = {
                deathBeds.add(
                    DeathBed(
                        firstName,
                        lastName,
                        causeOfDeath,
                    ),
                )
                navController.navigate(Routes.Main.route)
            }, enabled = isEnabled(firstName, lastName)) {
                Text("Add to death list")
            }
        }
    }
}

// Checks for the parameters to make sure they are not empty. Since causeOfDeath has a default
// starting value, it is never null. It also checks that the user has not been added to the death list already
@Composable
private fun isEnabled(
    firstName: String,
    lastName: String,
): Boolean {
    val deathBeds = LocalDeathBeds.current
    return firstName.isNotEmpty() && lastName.isNotEmpty() && deathBeds.find { it.id == "$firstName$lastName" } == null
}
