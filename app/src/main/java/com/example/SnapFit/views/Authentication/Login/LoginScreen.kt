package com.example.snapfit.views.authentication.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes
import com.example.snapfit.views.authentication.AuthViewModel
import com.example.snapfit.views.profile.ProfileViewModel

/**
 * Sign up screen for when a user logins to an existing account
 */


/**
 * Composable function representing the login screen of the SnapFit application.
 * This screen includes a background image, text inputs for email and password, and buttons for login and navigation to the signup screen.
 *
 * @param authViewModel The authentication ViewModel responsible for managing user authentication state.
 * @param profileViewModel The profile ViewModel responsible for managing user profiles.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    authViewModel: AuthViewModel,
    profileViewModel: ProfileViewModel,
) {
    val navController = LocalNavController.current
    val userState = authViewModel.currentUser().collectAsState()
    // Check if the user is already authenticated, if yes, navigate to the main screen
    if (userState.value != null) {
        profileViewModel.getProfile(userState.value!!.email)
        navController.navigate(Routes.Main.route)
    }

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
                    .fillMaxSize()
                    .padding(top = 200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            Text(
                text = "Welcome back",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(140.dp))

            TextField(
                value = email,
                onValueChange = {if(!it.contains("\n")) email = it },
                modifier =
                    Modifier
                        .size(325.dp, 90.dp)
                        .padding(8.dp)
                        .padding(8.dp),
                textStyle = TextStyle(fontSize = 16.sp),
                keyboardOptions =
                    KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next,
                    ),
                placeholder = { Text("Enter Email", color = Color.Black) },
            )

            TextField(
                value = password,
                onValueChange = {if(!it.contains("\n")) password = it }
                ,
                modifier =
                    Modifier
                        .size(325.dp, 90.dp)
                        .padding(8.dp)
                        .padding(8.dp),
                textStyle = TextStyle(fontSize = 16.sp),
                keyboardOptions =
                    KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done,
                    ),
                visualTransformation = PasswordVisualTransformation(),
                placeholder = { Text("Enter Password", color = Color.Black) },
            )
            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    authViewModel.signIn(email, password)
                    profileViewModel.getProfile(email)
                },
                modifier =
                    Modifier
                        .padding(end = 8.dp)
                        .size(325.dp, 40.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape =
                                MaterialTheme.shapes.medium.copy(
                                    bottomStart = CornerSize(16.dp),
                                    bottomEnd = CornerSize(16.dp),
                                    topStart = CornerSize(16.dp),
                                    topEnd = CornerSize(16.dp),
                                ),
                        ),
            ) {
                Text("Login",fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("━━━━━━━━━ OR ━━━━━━━━━")
            val signUpText = "Need an account? Sign up"

            ClickableText(
                text =
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(signUpText)
                        }
                    },
                onClick = { offset ->
                    if (offset < signUpText.length) {
                        navController.navigate(Routes.SignUp.route)
                    }
                },
            )
        }
    }
}