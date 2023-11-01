package com.example.assignment3.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.assignment3.R
import com.example.assignment3.navigation.Routes

/**
 * The about screen of the app, to display the use of the app.
 */
@Composable
fun StartUpScreen() {

    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp), // Add top padding of 16dp
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "To",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "SnapFit!",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )


        Button(
            onClick = {
                navController.navigate(Routes.Main.route)
            },
            modifier = Modifier
                .padding(end = 8.dp)
                .size(180.dp, 60.dp) // Set the button size to 180dp in width and 60dp in height
        ) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Handle the button click */ },
            modifier = Modifier
                .padding(end = 8.dp)
                .size(180.dp, 60.dp) // Set the button size to 180dp in width and 60dp in height
        ) {
            Text(text = "SignUp")
        }






    }
}
