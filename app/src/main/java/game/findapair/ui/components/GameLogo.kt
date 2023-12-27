package game.findapair.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import game.findapair.R

@Composable
fun GameLogo() {
    Image(
        painter = painterResource(id = R.drawable.game_logo),
        contentDescription = "Game logo",
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    )
}