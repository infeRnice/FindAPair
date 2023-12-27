package game.findapair.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun EndGamePopup(coinsWon: Int, onHomeClicked: () -> Unit, onDoubleRewardClicked: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Congratulations!")
        Text("You won $coinsWon!")
        Row {
            Button(onClick = onDoubleRewardClicked) {
                Text("Double reward")
            }
            Button(onClick = onHomeClicked) {
                Text("Home")
            }
        }
    }
}