package com.example.snapfit.views.authentication.signup

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes

/**
 * The about screen of the app, to display the use of the app.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel = remember { SignUpViewModel() }) {
    val navController = LocalNavController.current

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var comfirmPassword by remember { mutableStateOf("") }
        var weight by remember { mutableStateOf("") }

        Text(
            text = "Sign Up",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(30.dp))

        val usernameState by signUpViewModel.usernameState.collectAsState()
        TextField(
            value = usernameState,
            onValueChange = { signUpViewModel.setUsername(it) },
            modifier =
            Modifier
                .size(250.dp, 90.dp)
                .padding(8.dp)
                .border(3.dp, Color.Black)
                .padding(8.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
            ),
            placeholder = { Text("Enter UserName", color = Color.Gray) },
        )

        val passwordState by signUpViewModel.passwordState.collectAsState()
        TextField(
            value = passwordState,
            onValueChange = { signUpViewModel.setPassword(it) },
            modifier =
            Modifier
                .size(250.dp, 90.dp)
                .padding(8.dp)
                .border(3.dp, Color.Black)
                .padding(8.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
            ),
            placeholder = { Text("Enter Password", color = Color.Gray) },
        )

        val confirmPasswordState by signUpViewModel.confirmPasswordState.collectAsState()
        TextField(
            value = confirmPasswordState,
            onValueChange = { signUpViewModel.setConfirmPassword(it) },
            modifier =
            Modifier
                .size(250.dp, 90.dp)
                .padding(8.dp)
                .border(3.dp, Color.Black)
                .padding(8.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
            ),
            placeholder = { Text("Confirm Password", color = Color.Gray) },
        )

        val weightState by signUpViewModel.weightState.collectAsState()
        TextField(
            value = weightState,
            onValueChange = { signUpViewModel.setWeight(it) },
            modifier =
            Modifier
                .size(250.dp, 90.dp)
                .padding(8.dp)
                .border(3.dp, Color.Black)
                .padding(8.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
            ),
            placeholder = { Text("Enter Weight", color = Color.Gray) },
        )

        Button(
            onClick = { signUpViewModel.signUpUser() },
            modifier =
            Modifier
                .padding(end = 8.dp)
                .size(180.dp, 60.dp),
        ) {
            Text("Sign Up")
        }

        val navigateToMain by signUpViewModel.navigateToMain.collectAsState()
        if (navigateToMain) {
            navController.navigate(Routes.Main.route)
            signUpViewModel.setNavigateToMain(false)
        }

        val errorMessage by signUpViewModel.errorMessage.collectAsState()
        errorMessage?.let {
            Text(
                text = it,
                color = Color.Red,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
        }
    }
}