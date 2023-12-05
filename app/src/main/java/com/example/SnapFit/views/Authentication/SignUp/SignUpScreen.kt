package com.example.snapfit.views.authentication.signup

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.snapfit.R
import com.example.snapfit.entities.profile.Profile
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes
import com.example.snapfit.views.authentication.AuthViewModel
import com.example.snapfit.views.authentication.AuthViewModelFactory
import com.example.snapfit.views.profile.ProfileViewModel
import com.example.snapfit.views.profile.ProfileViewModelFactory

/**
 * The about screen of the app, to display the use of the app.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory()),
    profileViewModel: ProfileViewModel =
        viewModel(
            factory =
                ProfileViewModelFactory(),
        ),
) {
    val navController = LocalNavController.current
    val userState = authViewModel.currentUser().collectAsState()

    if (userState.value != null) {
        profileViewModel.getProfile(userState.value!!.email)
        navController.navigate(Routes.Main.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.backgroundpink), // Replace with your actual resource ID
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
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
                text = "Sign Up",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = email,
                onValueChange = { email = it },
                modifier =
                Modifier
                    .size(300.dp, 90.dp)
                    .padding(8.dp)
                    .border(3.dp, Color.Black)
                    .padding(8.dp),
                textStyle = TextStyle(fontSize = 14.sp),
                keyboardOptions =
                KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                ),
                placeholder = { Text("Enter email", color = Color.Gray) },
            )
            TextField(
                value = username,
                onValueChange = { username = it },
                modifier =
                Modifier
                    .size(300.dp, 90.dp)
                    .padding(8.dp)
                    .border(3.dp, Color.Black)
                    .padding(8.dp),
                textStyle = TextStyle(fontSize = 14.sp),
                keyboardOptions =
                KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                ),
                placeholder = { Text("Enter username", color = Color.Gray) },
            )


            TextField(
                value = password,
                onValueChange = { password = it },
                modifier =
                Modifier
                    .size(300.dp, 90.dp)
                    .padding(8.dp)
                    .border(3.dp, Color.Black)
                    .padding(8.dp),
                textStyle = TextStyle(fontSize = 14.sp),
                keyboardOptions =
                KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                ),
                visualTransformation = PasswordVisualTransformation(),
                placeholder = { Text("Enter Password (minimum 6)", color = Color.Gray) },
            )

            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                modifier =
                Modifier
                    .size(300.dp, 90.dp)
                    .padding(8.dp)
                    .border(3.dp, Color.Black)
                    .padding(8.dp),
                textStyle = TextStyle(fontSize = 14.sp),
                keyboardOptions =
                KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                ),
                visualTransformation = PasswordVisualTransformation(),
                placeholder = { Text("Confirm password", color = Color.Gray) },
            )

            TextField(
                value = orignalWeight,
                onValueChange = { orignalWeight = it },
                modifier =
                Modifier
                    .size(300.dp, 90.dp)
                    .padding(8.dp)
                    .border(3.dp, Color.Black)
                    .padding(8.dp),
                textStyle = TextStyle(fontSize = 14.sp),
                keyboardOptions =
                KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                ),
                placeholder = { Text("current Weight", color = Color.Gray) },
            )

            Text(
                text =
                buildAnnotatedString {
                    if (email.isEmpty()) {
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append("Email field is empty\n")
                        }
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append("Email not valid\n")
                        }

                    }  else if (username.length < 3) {
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append("Username is too short\n")
                        }
                    } else if (password.isEmpty()) {
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append("Password field is empty\n")
                        }
                    } else if (password.length < 6) {
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append("Password too short\n")
                        }
                    } else if (confirmPassword.isEmpty()) {
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append("Confirm password field is empty\n")
                        }
                    } else if (confirmPassword != password) {
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append("Passwords not matching\n")
                        }
                    } else if (orignalWeight.isEmpty()) {
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append("Current weight field is empty\n")
                        }
                    } else if (orignalWeight.toDoubleOrNull() == null) {
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append("Your weight has to be a number\n")
                        }
                    } else {
                        withStyle(style = SpanStyle(color = Color.Green)) {
                            append("It's good\n")
                        }
                    }
                },
                modifier = Modifier,
                fontSize = 24.sp,
            )

            Button(
                onClick = {
                    authViewModel.signUp(email, password)
                    profileViewModel.getProfile(email)
                    profileViewModel.setProfile(
                        Profile(
                            email = email,
                            name = "email",
                            currentWeight = orignalWeight.toDouble(),
                        ),
                    )
                },
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(250.dp, 40.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = MaterialTheme.shapes.medium.copy(
                            bottomStart = CornerSize(16.dp), // Adjust the radius as needed
                            bottomEnd = CornerSize(16.dp),
                            topStart = CornerSize(16.dp),
                            topEnd = CornerSize(16.dp)
                        )
                    ),
                enabled = email.isNotEmpty() && password.length >= 6 && password == confirmPassword && orignalWeight.length > 0 && orignalWeight.toDoubleOrNull() != null,
            ) {
                Text("Sign Up")


            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("━━━━━━━━━ OR ━━━━━━━━━")
            Spacer(modifier = Modifier.height(4.dp))
            val signUpText = "Already have an account"

            ClickableText(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(signUpText)
                    }
                },
                onClick = { offset ->
                    if (offset < signUpText.length) {
                        navController.navigate(Routes.Login.route)
                    }
                },)
        }
    }
}