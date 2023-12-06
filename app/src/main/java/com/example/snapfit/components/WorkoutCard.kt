import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
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


/**
Composable function for rendering a workout card, displaying details about a specific type of workout.

 */


/**
* This function generates a visually appealing card with information about the workout type,
* including the number of exercises and the estimated duration. It also provides a clickable
* area to navigate to the exercises screen for the specified workout type.
*
* @param type The type of workout (e.g., "cardio", "flexibility", "no equipment", "strength").
*
* Usage Example:
* WorkoutCard(type = "cardio")
*/
@Composable
fun WorkoutCard(type: String) {
    val navController = LocalNavController.current
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .border(2.dp, color = Color.Black, RoundedCornerShape(16.dp))
                .padding(5.dp)
                .background(color = Color(0xE3FAE4EF))
                .clickable {
                    navController.navigate("${Routes.Exercises.route}/$type")
                },
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
            when (type) {
                "cardio" -> {
                    Text(text = "5 exercises")
                    Text(text = "20 minutes")
                }
                "flexibility" -> {
                    Text(text = "8 exercises")
                    Text(text = "50 minutes")
                }
                "no equipment" -> {
                    Text(text = "15 exercises")
                    Text(text = "45 minutes")
                }
                "strength" -> {
                    Text(text = "6 exercises")
                    Text(text = "30 minutes")
                }
                else -> {
                    Text(text = "16 exercises")
                    Text(text = "45 minutes")
                }
            }
        }
        val painter =
            painterResource(
                id =
                    when (type) {
                        "strength" -> R.drawable.pushup
                        "flexibility" -> R.drawable.starfish
                        "cardio" -> R.drawable.burpees
                        "no equipment" -> R.drawable.cobrastretch

                        else -> R.drawable.chocolate // Provide a default resource ID or handle it as needed
                    },
            )
        Image(
            painter = painter,
            contentDescription = "Placeholder",
            contentScale = ContentScale.Fit,
            modifier =
                Modifier
                    .sizeIn(
                        minHeight = 150.dp,
                        minWidth = 200.dp,
                        maxWidth = 150.dp,
                        maxHeight = 100.dp,
                    ),
        )
    }
}