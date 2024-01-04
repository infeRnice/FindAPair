package game.findapair.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import game.findapair.R
import game.findapair.presentation.FindAPairViewModel
import game.findapair.ui.components.GameLogo
import game.findapair.ui.components.GradientButton

@Composable
fun MenuView(
    onSettingsClicked: () -> Unit,
    onPirvacyPolicyClicked: () -> Unit,
    navController: NavController,
    viewModel: FindAPairViewModel = viewModel()
) {

    val gradientColors = listOf(Color.Cyan, Color.Magenta, Color.Blue)
    val reverseGradientColors = listOf(Color.Magenta, Color.Blue, Color.Cyan)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GameLogo()
            Spacer(modifier = Modifier.height(20.dp))
            GradientButton(
                text = "PLAY",
                onClick = {
                    viewModel.resetGame()
                    navController.navigate("game") },
                gradientColors = gradientColors,
                reverseGradientColors = reverseGradientColors
            )

            Spacer(modifier = Modifier.height(20.dp))
            GradientButton(
                text = "Settings",
                onClick = onSettingsClicked,
                gradientColors = gradientColors,
                reverseGradientColors = reverseGradientColors
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        IconButton(
            onClick = onPirvacyPolicyClicked,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
                .size(50.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.privacypolicy),
                contentDescription = "Privacy Policy",
                modifier = Modifier.size(50.dp)
            )
        }
        Box(
            modifier = Modifier.align(Alignment.TopEnd)) {
            CurrencyDisplay(viewModel)
        }
    }
}

@Composable
fun CurrencyDisplay(viewModel: FindAPairViewModel) {
    val currency = viewModel.currency.collectAsState().value
    Row(
        modifier = Modifier
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.coin),
            contentDescription = "Coin Icon",
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "$currency", color = Color.Black)
    }
}