
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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

/**
Outputs an exercise card depending of the type of exercise. An exercise cards
contains a title for the type, a number of reps to accomplish it and is intractable
 */

/** This function generates a visually appealing card with information about the exercise type,
 * including the number of reps or duration. It is also intractable, changing color upon click.
 *
 * @param type The type of exercise (e.g., "Jogging", "burpees", "crunch", "rest", etc).
 *
 * Usage Example:
 * ExerciseCard(type = "burpees")
 */
@Composable
fun ExerciseCard(type: String, increment: (Int) -> Unit) {
    val navController = LocalNavController.current
    var isToggled by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(2.dp, color = Color.Black, shape = RoundedCornerShape(16.dp))
            .padding(5.dp)
            .background(if (!isToggled) Color(0xE3FAE4EF) else Color(0xE3FFADD7))
            .clickable {
                isToggled = !isToggled;
                if (!isToggled) increment(-1)
                else increment(+1)
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

            val description = when (type) {
                "Jogging" -> "\n 1km jogging"
                "burpees" -> "\n10 reps"
                "crunch" -> "\n30 reps"
                "rest" -> "\n30 seconds"
                "starfish" -> "\n60 seconds"
                "push up" -> "\n15 reps"
                "dumbbell curl" -> "\n20 reps"
                "repeat" -> "\n repeat 3 times"
                "repeatTwo" -> "\n repeat 2 times"
                "cobra stretch" -> "\n 45 seconds static hold"
                else -> "16 exercises\n45 minutes"
            }

            Text(text = description)
        }

        val imageResourceId = when (type) {
            "push up" -> R.drawable.pushup
            "burpees" -> R.drawable.burpees
            "crunch" -> R.drawable.crounch
            "rest" -> R.drawable.rest
            "Jogging" -> R.drawable.highheels
            "starfish" -> R.drawable.starfish
            "dumbbell curl" -> R.drawable.dumbbellcurl
            "repeat", "repeatTwo" -> R.drawable.repeat
            "cobra stretch" -> R.drawable.cobrastretch
            else -> R.drawable.chocolate
        }

        val painter = painterResource(id = imageResourceId)

        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.sizeIn(
                    minHeight = 150.dp,
                    minWidth = 200.dp,
                    maxWidth = 150.dp,
                    maxHeight = 100.dp,
                ),
        )
    }
}


