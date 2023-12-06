package com.example.SnapFit.views.Authentication.about

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.R
import com.example.snapfit.entities.profile.Profile
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
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }
            var orignalWeight by remember { mutableStateOf("") }
            var username by remember { mutableStateOf("") }

            Text(
                text = "About Us",
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
                        Text(
                            text = "SnapFit fitness app project created by passion to make an application we can be proud to demonstrate. Something unique that will be able to help people by making a positive impact on the lives of individuals. In today's busy world, maintaining a consistent fitness regimen can be challenging. This is why we want to create an application that will help people stay active without complicating how to stay in shape.",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier =
                            Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(20.dp),
                        )


                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Contact us: Snapfit@hotmail.com \n 514-123-456",
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