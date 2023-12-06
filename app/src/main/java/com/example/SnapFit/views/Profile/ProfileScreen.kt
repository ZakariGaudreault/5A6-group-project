package com.example.snapfit.views.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.R
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes
import com.example.snapfit.views.authentication.AuthViewModel
import kotlinx.coroutines.runBlocking

/**
 * Class that showcase the features of a user profile
 */


/**
 * Composable function for the profile screen of the app, displaying user information, navigation buttons,
 * and a list of cards.
 *
 * @param authViewModel ViewModel for authentication-related operations.
 * @param profileViewModel ViewModel for accessing user profile data.
 */
@Composable
fun ProfileScreen(
    authViewModel: AuthViewModel,
    profileViewModel: ProfileViewModel,
) {
    // Access the navigation controller
    val navController = LocalNavController.current

    // Collect the active profile state using StateFlow
    val profileState = profileViewModel.activeProfile.collectAsState()

    // Column composable to arrange child composables vertically
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Text composable displaying the user's name and indicating it's the profile screen
        Text(
            text = "${profileState.value.name}'s profile",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )

        // Row composable containing buttons for navigating to workout history and snaps
        Row {
            Button(onClick = { /* TODO: Navigate to workout history */ }, modifier = Modifier.padding(end = 8.dp)) {
                Text(text = "History of Workouts")
            }

            Button(onClick = { /* TODO: Navigate to snaps */ }) {
                Text(text = "Snaps")
            }
        }

        // Row composable containing buttons for uploading, viewing graphs, and logging out
        Row {
            Button(onClick = {
                navController.navigate(Routes.Upload.route)
            }, modifier = Modifier.padding(end = 8.dp)) {
                Text(text = "Upload")
            }
            Button(onClick = { /* TODO: Navigate to graph */ }, modifier = Modifier.padding(end = 8.dp)) {
                Text(text = "Graph")
            }
            Button(onClick = {
                runBlocking {
                    authViewModel.signOut()
                    navController.navigate(Routes.Auth.route)
                }
            }, modifier = Modifier.padding(end = 8.dp)) {
                Text(text = "Log out")
            }
        }

        // Spacer composable for adding vertical space between buttons and the card list
        Spacer(modifier = Modifier.height(16.dp))

        // CardList composable to display a list of cards
        CardList()
    }
}

/**
 * Composable function for displaying a list of cards.
 */
@Composable
fun CardList() {
    // Generate a list of dummy cards
    val cards by remember { mutableStateOf(generateDummyCards()) }

    // LazyColumn composable to efficiently display a scrollable list of items
    LazyColumn {
        // Iterate through the list of cards and display CardItem for each card
        items(cards) { card ->
            CardItem(card = card)
        }
    }
}

/**
 * Data class representing an item in the card list.
 *
 * @param text Text content of the card.
 * @param imageUrl URL for the image of the card.
 */
data class CardItem(val text: String, val imageUrl: String)

/**
 * Function to generate a list of dummy cards.
 */
fun generateDummyCards(): List<CardItem> {
    return List(5) { index ->
        CardItem(
            text = "Card $index",
            imageUrl = "https://dummyimage.com/200x200/000/fff",
        )
    }
}

/**
 * Composable function for displaying an individual card item.
 *
 * @param card CardItem representing the content and image URL of the card.
 */
@Composable
fun CardItem(card: CardItem) {
    // Card composable to display a card item with text and an image
    Card(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        // Column composable to arrange child composables vertically within the card
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            // Text composable displaying the card text with bold font
            Text(text = card.text, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            // Spacer composable for adding vertical space between text and image
            Spacer(modifier = Modifier.height(8.dp))
            // Image composable displaying the card image
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
            )
            // Button composable for potential actions related to the card item
            Button(onClick = { /* TODO: Implement delete action */ }) {
                Text(text = "Delete")
            }
        }
    }
}
