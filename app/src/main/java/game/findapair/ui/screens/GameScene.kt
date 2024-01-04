package game.findapair.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import game.findapair.R
import game.findapair.presentation.FindAPairViewModel
import game.findapair.ui.components.CardView
import game.findapair.ui.components.TimerDisplay

val imageIds = listOf(
    R.drawable.a,
    R.drawable.b,
    R.drawable.c,
    R.drawable.d,
    R.drawable.e,
    R.drawable.f,
    R.drawable.g,
    R.drawable.h,
    R.drawable.i,
    R.drawable.j
)

fun generateShuffledCards(): List<Pair<Int, Int>> {
    val doubleCards = (imageIds.indices + imageIds.indices).shuffled()
    return doubleCards.map { index -> Pair(index, imageIds[index % imageIds.size]) }
}

@Composable
fun GameScene(viewModel: FindAPairViewModel, navController: NavController) {

    val timerState = remember { mutableStateOf(60) }
    val shuffledCards = remember { generateShuffledCards() }

    // Наблюдение за состоянием совпавших карт
    LaunchedEffect(viewModel.matchedCards.collectAsState().value) {
        if (viewModel.isGameCompleted()) {
            viewModel.calculateReward(timerState.value)
            navController.navigate("endGame")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentWidth(Alignment.Start)
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TimerDisplay(timerState)
            Spacer(modifier = Modifier.weight(1f))
            CurrencyDisplay(viewModel)

        }

        Spacer(modifier = Modifier.height(20.dp))

        GameGrid(shuffledCards, viewModel)

        Text(
            text = "Keep matching up two of the same object until there are no more to be paired and you clear the board.",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Fast",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GameGrid(cards: List<Pair<Int, Int>>, viewModel: FindAPairViewModel) {
    Column {
        for (row in 0 until 5) { //5 lines
            Row {
                for (column in 0 until 4) { //4 column
                    val cardIndex = row * 4 + column
                    val (cardId, imageId) = cards[cardIndex]
                    CardView(cardIndex, imageId, viewModel)
                }
            }
        }
    }
}