package com.example.assignment3.components

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.assignment3.R


/**
 * List that holds a variety of creative death causes, while association an image to it. Friendly types of death since we are family friendly
 * and also don't want to wish a real death upon anyone.
 */
val CAUSES_OF_DEATH: List<Cause> = listOf(
    Cause("Pooping way too much", R.drawable.poop),
    Cause("Eating too many fries",R.drawable.fries),
    Cause("Eating !dark chocolate",R.drawable.chocolate),
    Cause("Procrastinating too much for App Dev2",R.drawable.procrastination),
    Cause("Sleeping too much in class", R.drawable.sleeping)
)
