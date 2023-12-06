package com.example.SnapFit.components

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.R
import com.example.snapfit.navigation.LocalNavController

@Composable
fun PromotionsCard(email:String?) {
    val localContext = LocalContext.current
    val activity = localContext as ComponentActivity
    val navController = LocalNavController.current
    Row(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(5.dp, color = Color.Black, RoundedCornerShape(16.dp))
            .padding(5.dp)
            .clickable { val resultIntent = activity.intent
                resultIntent.putExtra(
                    "resultData", "the offer has been claimed by $email"
                ) // Set the value to return as a result
                localContext.setResult(Activity.RESULT_OK, resultIntent)
                localContext.finish() // Finish the activity
    },
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Click Here to Get your 50% off Coupon",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )

        }
        Image(
            painter = painterResource(id = R.drawable.fifty),
            contentDescription = "Placeholder",
            contentScale = ContentScale.Fit,
            modifier = Modifier.weight(1f),
        )
    }
}