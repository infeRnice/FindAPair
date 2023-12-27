package game.findapair.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit,
    gradientColors: List<Color>,
    reverseGradientColors: List<Color>
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Transparent
        ),
        modifier = Modifier
            .background(Color.Transparent)
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(colors = reverseGradientColors),
                shape = MaterialTheme.shapes.small
            )

    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(
                brush = Brush.linearGradient(colors = gradientColors)
            )
        )
    }
}