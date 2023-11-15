package com.example.snapfit.views.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.snapfit.views.profile.ProfileViewModel
import com.example.snapfit.views.profile.ProfileViewModelFactory

/**
 * The main screen of the app, which displays the list of all the potential deathbeds
 */
@Composable
fun MainScreen(profileViewModel: ProfileViewModel = viewModel(factory = ProfileViewModelFactory())) {
    val userState = profileViewModel.activeProfile.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Box {
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Hello ${userState.value.email}",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp),
                )

                Text(
                    text = "Let's check your activity",
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp),
                )

                Box(
                    modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                ) {
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                    ) {
                        Column(
                            modifier =
                                Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                        ) {
                            Card(
                                modifier =
                                    Modifier
                                        .fillMaxWidth()
                                        .height(310.dp)
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
                                        text = "\uD83D\uDCAA" + "FINISHED",
                                        fontSize = 26.sp,
                                        fontWeight = FontWeight.Bold,
                                    )

                                    Text(
                                        text = "${userState.value.currentWeight}",
                                        fontSize = 100.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(16.dp),
                                    )

                                    Text(
                                        text = "\u200E \u200E Workout",
                                        fontSize = 30.sp,
                                        modifier = Modifier.padding(16.dp),
                                    )
                                }
                            }
                        }

                        Column(
                            modifier =
                                Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .padding(8.dp),
                        ) {
                            Card(
                                modifier =
                                    Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
                                        .padding(bottom = 8.dp)
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
                                Text(
                                    buildAnnotatedString {
                                        append("\uD83C\uDFC6 You lost ")
                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                            append("${userState.value.currentWeight - userState.value.originalWeight}")
                                        }
                                        append(" pounds so far")
                                    },
                                    modifier = Modifier.padding(16.dp),
                                    fontSize = 24.sp,
                                )
                            }

                            Card(
                                modifier =
                                    Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
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
                                Text(
                                    buildAnnotatedString {
                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                            append("⏱️ Time Spent \n\n\n")
                                        }
                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                            append("\u200E \u200E \u200E \u200E 27.3")
                                        }
                                        append(" hours ")
                                    },
                                    modifier = Modifier.padding(4.dp),
                                    fontSize = 20.sp,
                                )
                            }
                        }
                    }
                    Card(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 340.dp)
                                .border(3.dp, Color.Black, shape = RoundedCornerShape(16.dp)),
                        colors =
                            CardDefaults.cardColors(
                                containerColor = Color.White,
                                contentColor = Color.Black,
                            ),
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(16.dp),
                        ) {
                            Text(
                                text = "Quote of the Day",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "Fitness is not about competing with others. It's about competing with yourself and working to be better than you were yesterday",
                                fontSize = 16.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}