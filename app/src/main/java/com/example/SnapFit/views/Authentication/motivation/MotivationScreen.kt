package com.example.snapfit.views.authentication.motivation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.R
import com.example.snapfit.navigation.LocalNavController

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
fun MotivationScreen() {
    val navController = LocalNavController.current
    val logo: Painter = painterResource(id = R.drawable.logo)
    Box(
        modifier =
            Modifier
                .fillMaxSize(),
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
            modifier =
                Modifier
                    .fillMaxSize(),
            // Add top padding of 16dp
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Motivation",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(20.dp))

            Box(modifier = Modifier.padding(20.dp)) {
                Card(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .height(520.dp)
                            .border(
                                3.dp,
                                Color.Black,
                                shape = RoundedCornerShape(16.dp),
                            ),
                    colors =
                        CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = Color.Black,
                        ),
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        Spacer(modifier = Modifier.height(10.dp))

                        Image(
                            painter = logo,
                            contentDescription = null,
                            modifier =
                            Modifier
                                .clip(MaterialTheme.shapes.medium)
                                .sizeIn(
                                    maxWidth = 100.dp,
                                    maxHeight = 100.dp,
                                ),
                            contentScale = ContentScale.Crop,
                        )
                        Text(
                            text = "SnapFit fitness app project created by passion to make an application we can be proud to demonstrate. Something unique that will be able to help people by making a positive impact on the lives of individuals. In today's busy world, maintaining a consistent fitness regimen can be challenging. This is why we want to create an application that will help people stay active without complicating how to stay in shape.",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier =
                                Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .padding(20.dp),
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Contact us: Snapfit@hotmail.com \n Phone: 514-123-456",
                            fontSize = 12.sp,
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