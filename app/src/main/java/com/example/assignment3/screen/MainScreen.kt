package com.example.assignment3.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment3.R

/**
 * The main screen of the app, which displays the list of all the potential deathbeds
 */
@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )

            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Home Page",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 16.dp),
                )

                Text(
                    text = "Welcome!!!",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp),
                )

                Text(
                    text =
                        "Lorem ipsum dolor sit amet, consectetuer adipiscing" +
                            " elit. Maecenas porttitor congue massa. Fusce posuere," +
                            " magna sed pulvinar ultricies, purus lectus malesuada " +
                            "libero, sit amet commodo magna eros quis urna. Nunc viverra" +
                            " imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque " +
                            "habitant morbi tristique senectus et netus et malesuada fames ac" +
                            " turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean" +
                            " nec lorem. In porttitor. Donec laoreet nonummy augue. Suspendisse dui" +
                            " purus, scelerisque at, vulputate vitae, pretium mattis, nunc. Mauris eget" +
                            " neque at sem venenatis eleifend. Ut nonummy.",
                    fontSize = 16.sp,
                    color = Color.White,
                )
            }
        }
    }
}
