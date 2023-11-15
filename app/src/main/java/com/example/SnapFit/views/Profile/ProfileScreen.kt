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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.snapfit.R
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes
import com.example.snapfit.views.authentication.home.AuthViewModel
import com.example.snapfit.views.authentication.home.AuthViewModelFactory

/**
 * The about screen of the app, to display the use of the app.
 */
@Composable
fun ProfileScreen(
    authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory()),
    profileViewModel: ProfileViewModel =
        viewModel(
            factory =
                ProfileViewModelFactory
                (),
        ),
) {
    val navController = LocalNavController.current
    val profileState = profileViewModel.activeProfile.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = profileState.value.email,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )

        Row {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(end = 8.dp)) {
                Text(text = "History of Workouts")
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Snaps")
            }
        }

        Row {
            Button(onClick = { navController.navigate(Routes.Upload.route) }, modifier = Modifier.padding(end = 8.dp)) {
                Text(text = "Upload")
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(end = 8.dp)) {
                Text(text = "Graph")
            }
            Button(onClick = {
                authViewModel.signOut()
                navController.navigate(Routes.Auth.route)
            }, modifier = Modifier.padding(end = 8.dp)) {
                Text(text = "Log out")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        CardList()
    }
}

@Composable
fun CardList() {
    val cards by remember { mutableStateOf(generateDummyCards()) }

    LazyColumn {
        items(cards) { card ->
            CardItem(card = card)
        }
    }
}

data class CardItem(val text: String, val imageUrl: String)

fun generateDummyCards(): List<CardItem> {
    return List(5) { index ->
        CardItem(
            text = "Card $index",
            imageUrl = "https://dummyimage.com/200x200/000/fff",
        )
    }
}

@Composable
fun CardItem(card: CardItem) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
        ) {
            Text(text = card.text, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp),
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Delete")
            }
        }
    }
}