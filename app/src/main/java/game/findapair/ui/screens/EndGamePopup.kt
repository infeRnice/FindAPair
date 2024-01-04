package game.findapair.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import game.findapair.R
import game.findapair.presentation.FindAPairViewModel
import game.findapair.ui.components.GradientButton

@Composable
fun EndGamePopup(navController: NavController, viewModel: FindAPairViewModel) {

    val gradientColors = listOf(Color.Cyan, Color.Magenta, Color.Blue)
    val reverseGradientColors = listOf(Color.Magenta, Color.Blue, Color.Cyan)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.goblet),
            contentDescription = "Trophy"
        )
        Text(
            "CONGRATULATIONS!",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 30.sp)
        )
        Text(
            text = "Great! You won!",
            style = MaterialTheme.typography.bodySmall.copy(fontSize = 18.sp),
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )
        CurrencyDisplay(viewModel)
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            GradientButton(
                text = "Double Reward",
                onClick = { /* Double reward logic */ },
                gradientColors = gradientColors,
                reverseGradientColors = reverseGradientColors
            )
            Spacer(modifier = Modifier.width(2.dp))
            GradientButton(
                text = "Home",
                onClick = { navController.navigate("menu") },
                gradientColors = gradientColors,
                reverseGradientColors = reverseGradientColors
            )
        }

    }
}
