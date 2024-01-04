package game.findapair.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import game.findapair.presentation.FindAPairViewModel
import game.findapair.ui.screens.EndGamePopup
import game.findapair.ui.screens.GameScene
import game.findapair.ui.screens.MenuView

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val viewModel: FindAPairViewModel = viewModel()

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MenuView(

                onSettingsClicked = { /*open settings */ },
                onPirvacyPolicyClicked = { /*open policy */ },
                navController = navController,
                viewModel = viewModel
            )
        }

        composable("game") {
            GameScene(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable("endGame") {
            EndGamePopup(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}