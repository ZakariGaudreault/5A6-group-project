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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.views.profile.ProfileViewModel
import kotlin.math.absoluteValue

@Composable
fun MainScreen(profileViewModel: ProfileViewModel) {
    val userState by profileViewModel.activeProfile.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Box {
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Hello ${userState.name}",
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
                                        modifier =
                                            Modifier
                                                .align(Alignment.CenterHorizontally),
                                    )

                                    Text(
                                        text = "${userState.amountWorkoutDone}",
                                        fontSize = 40.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier =
                                            Modifier
                                                .padding(vertical = 50.dp)
                                                .widthIn(max = 150.dp)
                                                .align(Alignment.CenterHorizontally),
                                    )

                                    Text(
                                        text = "\u200E \u200E Workout",
                                        fontSize = 30.sp,
                                        modifier =
                                            Modifier.padding(
                                                16.dp,
                                            ).padding(vertical = 20.dp),
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
                                        val weightDifference = userState.currentWeight - userState.originalWeight
                                        val gainOrLostText = if (weightDifference >= 0) "gained" else "lost"

                                        append("\uD83C\uDFC6 You $gainOrLostText ")
                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                            append(
                                                "${weightDifference.absoluteValue}",
                                            ) // Using absolute value to ensure a positive difference
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
                    val fitnessQuotes =
                        listOf(
                            "Fitness is not about competing with others. It's about competing with yourself and working to be better than you were yesterday",
                            "Your body can stand almost anything. It's your mind that you have to convince.",
                            "The only bad workout is the one that didn't happen.",
                            "The only way to achieve the impossible is to believe it is possible.",
                            "Success is usually the culmination of controlling failure.",
                            "The difference between a goal and a dream is a deadline.",
                            "Strength does not come from the body. It comes from the will.",
                            "The only place where success comes before work is in the dictionary.",
                            "You don't have to be extreme, just consistent.",
                            "Your body is a reflection of your lifestyle.",
                            "The pain you feel today will be the strength you feel tomorrow.",
                            "Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.",
                            "Don't count the days, make the days count.",
                            "The only bad workout is the one that didn't happen.",
                            "Your only limit is you.",
                        )

                    val randomQuote = fitnessQuotes.random()
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
                                text = "Motivation quote",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = randomQuote,
                                fontSize = 16.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}