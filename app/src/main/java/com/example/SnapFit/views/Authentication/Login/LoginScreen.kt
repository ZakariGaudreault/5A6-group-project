package com.example.snapfit.views.authentication.login

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes
import com.example.snapfit.views.authentication.home.AuthViewModel
import com.example.snapfit.views.authentication.home.AuthViewModelFactory

/**
 * The about screen of the app, to display the use of the app.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory())) {
    val navController = LocalNavController.current
    val userState = authViewModel.currentUser().collectAsState()
    if (userState.value != null) {
        navController.navigate(Routes.Main.route)
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Text(
            text = "Login",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(70.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            modifier =
                Modifier
                    .size(250.dp, 90.dp)
                    .padding(8.dp)
                    .border(3.dp, Color.Black)
                    .padding(8.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions =
                KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                ),
            placeholder = { Text("Enter UserName", color = Color.Gray) },
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            modifier =
                Modifier
                    .size(250.dp, 90.dp)
                    .padding(8.dp)
                    .border(3.dp, Color.Black)
                    .padding(8.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions =
                KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                ),
            visualTransformation = PasswordVisualTransformation(),
            placeholder = { Text("Enter Password", color = Color.Gray) },
        )

        Button(
            onClick = {
                authViewModel.signIn(email, password)
            },
            modifier =
                Modifier
                    .padding(end = 8.dp)
                    .size(180.dp, 60.dp),
        ) {
            Text("Login")
        }
    }
}