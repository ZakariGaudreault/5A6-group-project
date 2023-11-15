package com.example.snapfit.views.authentication.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes

/**
 * The about screen of the app, to display the use of the app.
 */
@Composable
fun AuthScreen(authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory())) {
    val navController = LocalNavController.current
    val userState = authViewModel.currentUser().collectAsState()

    if(userState.value != null ){
        navController.navigate(Routes.Main.route)
    }

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "SnapFit",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )

        Button(
            onClick = {
                navController.navigate(Routes.Login.route)
            },
            modifier =
                Modifier
                    .padding(end = 8.dp)
                    .size(180.dp, 60.dp),
        ) {
            Text("Login")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate(Routes.SignUp.route)
                      },
            modifier =
                Modifier
                    .padding(end = 8.dp)
                    .size(180.dp, 60.dp),
        ) {
            Text(text = "SignUp")
        }
    }
}