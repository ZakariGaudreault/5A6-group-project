package com.example.snapfit.views.authentication.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.R
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes
import com.example.snapfit.views.authentication.AuthViewModel


@Composable
fun AuthScreen(authViewModel: AuthViewModel) {
    val navController = LocalNavController.current

    // Gradient background with wavy shape
    val backgroundPainter: Painter = painterResource(id = R.drawable.backgroundpink)
    val logo: Painter = painterResource(id = R.drawable.logo)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent), // Set the background color to transparent
    ) {
        Image(
            painter = backgroundPainter,
            contentDescription = null, // Set to null if it's a decorative image
            modifier = Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "SnapFit",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.purple_200)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                painter = logo,
                contentDescription = null,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .sizeIn(
                        maxWidth = 200.dp,
                        maxHeight = 200.dp
                    )
                    .border(1.dp, Color.Black),
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier.height(150.dp))
            Button(
                onClick = {
                    navController.navigate(Routes.Login.route)
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
            ) {
                Text("Login")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text("━━━━━━━━━ OR ━━━━━━━━━")
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {
                    navController.navigate(Routes.SignUp.route)
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
            ) {
                Text(text = "SignUp")
            }
        }
    }
}

@Composable
fun getGradientBrush(): Brush {
    return Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFE3FAE4EF),
            Color(0xFFA5D6A7),
            Color(0xFF43A047)
        )
    )
}