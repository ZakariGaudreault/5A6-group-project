import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.snapfit.ui.theme.md_theme_light_primary

@Composable
fun PushUpcard() {
    val navController = LocalNavController.current
    var isToggled by remember { mutableStateOf(false) }

    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .border(5.dp, color = Color.Black, RoundedCornerShape(16.dp))
                .padding(5.dp)
                .background(
                    if (!isToggled) Color.White else md_theme_light_primary,
                )
                .clickable { isToggled = !isToggled },
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Push ups",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Text(text = "20 reps")
        }
        Image(
            painter = painterResource(id = R.drawable.pushup),
            contentDescription = "Placeholder",
            contentScale = ContentScale.Fit,
            modifier = Modifier.weight(1f),
        )
    }
}