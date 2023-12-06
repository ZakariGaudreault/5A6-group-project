package com.example.snapfit.views.authentication.home

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
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.R
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes
import com.example.snapfit.views.authentication.AuthViewModel
import com.example.snapfit.views.profile.ProfileViewModel

/**
 * Screen for Authentication which is the first page the user will see when opening the app
 */

/**
 * Composable function representing the authentication screen of the SnapFit application.
 * This screen includes a wavy gradient background, the SnapFit logo, and buttons for login and signup.
 *
 * @param authViewModel The authentication ViewModel responsible for managing user authentication state.
 */
@Composable
fun AuthScreen(profileViewModel: ProfileViewModel, authViewModel: AuthViewModel) {
    val navController = LocalNavController.current

    // Gradient background with wavy shape
    val backgroundPainter: Painter = painterResource(id = R.drawable.backgroundpink)
    val logo: Painter = painterResource(id = R.drawable.logo)

    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .background(color = Color.Transparent),
        // Set the background color to transparent
    ) {
        Image(
            painter = backgroundPainter,
            contentDescription = null,
            modifier =
            Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(top = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "SnapFit",
                fontSize = 60.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(R.color.purple_200),
                fontFamily = FontFamily.Cursive,
            )
            Spacer(modifier = Modifier.height(80.dp))
            Image(
                painter = logo,
                contentDescription = null,
                modifier =
                Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .sizeIn(
                        maxWidth = 200.dp,
                        maxHeight = 200.dp,
                    ),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(150.dp))
            Button(
                onClick = {
                    navController.navigate(Routes.Login.route)
                },
                modifier =
                    Modifier
                        .padding(end = 8.dp)
                        .size(250.dp, 40.dp)
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
                Text("Login")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text("━━━━━━━━━ OR ━━━━━━━━━")
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {
                    navController.navigate(Routes.SignUp.route)
                },
                modifier =
                    Modifier
                        .padding(end = 8.dp)
                        .size(250.dp, 40.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape =
                                MaterialTheme.shapes.medium.copy(
                                    bottomStart = CornerSize(16.dp), // Adjust the radius as needed
                                    bottomEnd = CornerSize(16.dp),
                                    topStart = CornerSize(16.dp),
                                    topEnd = CornerSize(16.dp),
                                ),
                        ),
            ) {
                Text(text = "SignUp")
            }
        }
    }
}
/**
 * Function to get a horizontal gradient brush for the authentication screen background in case the image does not work.
 *
 * Usage Example:
 * val gradientBrush: Brush = getGradientBrush()
 * @return A Brush representing the horizontal gradient.
 */
@Composable
fun getGradientBrush(): Brush {
    return Brush.horizontalGradient(
        colors =
            listOf(
                Color(0xFFE3FAE4EF),
                Color(0xFFA5D6A7),
                Color(0xFF43A047),
            ),
    )
}