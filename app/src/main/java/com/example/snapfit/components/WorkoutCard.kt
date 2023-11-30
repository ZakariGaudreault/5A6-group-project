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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snapfit.R
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes

@Composable
fun WorkoutCard(type: String) {
    val navController = LocalNavController.current
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .border(5.dp, color = Color.Black, RoundedCornerShape(16.dp))
                .padding(5.dp)
                .clickable { navController.navigate("${Routes.Exercises.route}/$type") },
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = type,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Text(text = "16 exercises")
            Text(text = "45 minutes")
        }
        val painter =
            painterResource(
                id =
                    when (type) {
                        "strength" -> R.drawable.pushup
                        "flexibility" -> R.drawable.starfish
                        "cardio" -> R.drawable.burpees
                        "no equipment" -> R.drawable.highheels
                        // Add more cases for other exercise types if needed
                        else -> R.drawable.chocolate // Provide a default resource ID or handle it as needed
                    },
            )
        Image(
            painter = painter,
            contentDescription = "Placeholder",
            contentScale = ContentScale.Fit,
            modifier = Modifier.weight(1f),
        )
    }
}