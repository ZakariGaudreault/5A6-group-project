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
import androidx.compose.runtime.remember
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
fun ExerciseCard(type: String) {

    // current location on the app
    val navController = LocalNavController.current
    //keep the state of the card which changes color upon click
    var isToggled by remember { mutableStateOf(false) }

    //puts the whole content in a row
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .border(5.dp, color = Color.Black, RoundedCornerShape(16.dp))
                .padding(5.dp)
                .background(
                    if (!isToggled) Color(0xE3FAE4EF) else Color(0xE3FFADD7),
                )
                .clickable { isToggled = !isToggled },
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
            //depending of the title, a description will be outputed for the card
            when (type) {
                "Jogging" -> {
                    Text(text = "\n 1km jogging")
                }
                "burpees" -> {
                    Text(text = "\n10 reps")
                }
                "crunch" -> {
                    Text(text = "\n30 reps")
                }
                "rest" -> {
                    Text(text = "\n30 seconds")
                }
                "starfish" -> {
                    Text(text = "\n60 seconds")
                }
                "push up" -> {
                    Text(text = "\n15 reps")
                }
                "dumbbell curl" -> {
                    Text(text = "\n20 reps")
                }
                "repeat" -> {
                    Text(text = "\n repeat 3 times")
                }
                "repeatTwo" -> {
                    Text(text = "\n repeat 2 times")
                }
                "cobra stretch" -> {
                    Text(text = "\n 45 seconds static hold")
                }
                else -> {
                    Text(text = "16 exercises")
                    Text(text = "45 minutes")
                }
            }
        }

        //outputs an image depending of the name of the exercise
        val painter =
            painterResource(
                id =
                    when (type) {
                        "push up" -> R.drawable.pushup
                        "burpees" -> R.drawable.burpees
                        "crunch" -> R.drawable.crounch
                        "rest" -> R.drawable.rest
                        "Jogging" -> R.drawable.highheels
                        "starfish" -> R.drawable.starfish
                        "dumbbell curl" -> R.drawable.dumbbellcurl
                        "repeat" -> R.drawable.repeat
                        "repeatTwo" -> R.drawable.repeat
                        "cobra stretch" -> R.drawable.cobrastretch
                        else -> R.drawable.chocolate
                    },
            )
        //defines the dimension of an image
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