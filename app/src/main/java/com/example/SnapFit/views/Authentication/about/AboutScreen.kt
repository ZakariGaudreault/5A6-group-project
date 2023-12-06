package com.example.snapfit.views.authentication.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.R
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes
import com.example.snapfit.views.authentication.AuthViewModel
import com.example.snapfit.views.profile.ProfileViewModel

/**
 * Sign up screen for when a user creates an account
 */

/**
 * Composable function representing the sign-up screen of the SnapFit application.
 * This screen includes a background image, text inputs for email, username, password, and current weight, and buttons for sign-up and navigation to the login screen.
 *
 * @param authViewModel The authentication ViewModel responsible for managing user authentication state.
 * @param profileViewModel The profile ViewModel responsible for managing user profiles.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    authViewModel: AuthViewModel,
    profileViewModel: ProfileViewModel,
) {
    val navController = LocalNavController.current
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Background Image
        Image(
            painter =
                painterResource(
                    id = R.drawable.backgroundpink,
                ),
            // Replace with your actual resource ID
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            // Add top padding of 16dp
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "How to use",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Box(modifier = Modifier.padding(20.dp)) {
                Card(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .height(520.dp)
                            .border(
                                2.dp,
                                Color.Black,
                                shape = RoundedCornerShape(16.dp),
                            )
                            .clickable { navController.navigate(Routes.Us.route) },
                    colors =
                        CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = Color.Black,
                        ),
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = "There are three screens:\n\n" +
                                "Home screen is where you can see your stats. Click on your number of workouts to see your past workouts." +
                                "Click on the motivation and use the camera to take a snap to keep track of your shape and weight.\n\n" +
                                "Workout screen is where all the workouts are available, filter them by the ones you want to do." +
                                "Click on one, and you have the list of exercises. Click on each exercises, to complete them, at the end, you'll be able to complete the workout" +
                                "\n\nThe final page is your user page, with all the snaps you have",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier =
                                Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .padding(20.dp),
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Click anywhere in the box to see why we crated this app.",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier =
                                Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .padding(20.dp),
                        )
                    }
                }
            }
        }
    }
}