package com.example.snapfit.views.DeepLink

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.SnapFit.components.PromotionsCard

@Composable
fun DeepLink(email:String?) {
    Column(
        modifier =
        Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Secret Promotion page!!! $email",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )

            PromotionsCard(email)

        }
    }
}