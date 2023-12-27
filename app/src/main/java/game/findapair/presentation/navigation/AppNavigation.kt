package game.findapair.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import game.findapair.ui.screens.EndGamePopup
import game.findapair.ui.screens.GameScene
import game.findapair.ui.screens.MenuView

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MenuView(
                /*onPlayClicked = { *//* ignore *//* },*/
                onSettingsClicked = { /*open settings */ },
                onPirvacyPolicyClicked = { /*open policy */ },
                navController = navController
            )
        }

        composable("game") {
            GameScene()
        }
        composable("endGame") {
            EndGamePopup(
                coinsWon = 100, //example
                onHomeClicked = { navController.popBackStack("menu", inclusive = false) },
                onDoubleRewardClicked = { navController.popBackStack("game", inclusive = false) }
            )
        }
    }
}