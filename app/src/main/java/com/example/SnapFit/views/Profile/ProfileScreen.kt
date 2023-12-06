package com.example.snapfit.views.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.snapfit.entities.progress.Progress
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes
import com.example.snapfit.views.authentication.AuthViewModel
import com.example.snapfit.views.progress.ProgressViewModel
import kotlinx.coroutines.runBlocking

/**
 * Class that showcase the features of a user profile
 */

//https://medium.com/@emmanuelmuturia/how-to-add-and-retrieve-images-from-firebase-storage-using-jetpack-compose-dedda31ff66d

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
    progressViewModel: ProgressViewModel
) {
    // Access the navigation controller
    val navController = LocalNavController.current

    // Collect the active profile state using StateFlow
    val profileState = profileViewModel.activeProfile.collectAsState()
    val progress = progressViewModel.activeProgress.collectAsState().value
    progressViewModel.getAllProgress(profileState.value.email)
//    val allProgress = rememberMutableStateListOf<List<Progress>>(progress)

    // Column composable to arrange child composables vertically
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Text composable displaying the user's name and indicating it's the profile screen
        Text(
            text = "Hello ${profileState.value.name}",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )

        // Row composable containing buttons for uploading, viewing graphs, and logging out
        Column {
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
        CardList(progress)
    }
}

/**
 * Composable function for displaying a list of cards.
 */
@Composable
fun CardList(progress: List<Progress>) {
    // LazyColumn composable to efficiently display a scrollable list of items
    LazyColumn {
        // Iterate through the list of cards and display CardItem for each card
        items(progress) { singleProgress ->
            CardItem(card = singleProgress)
        }
    }
}


/**
 * Composable function for displaying an individual card item.
 *
 * @param card CardItem representing the content and image URL of the card.
 */
@Composable
fun CardItem(card: Progress) {

    // Card composable to display a card item with text and an image
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        // Column composable to arrange child composables vertically within the card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            // Text composable displaying the card text with bold font
            Text(
                text = card.timestamp.toDate().toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(text = "${card.weight} lb", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            // Spacer composable for adding vertical space between text and image
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(model = card.url, contentDescription = "image")
            // Button composable for potential actions related to the card item
        }
    }
}
