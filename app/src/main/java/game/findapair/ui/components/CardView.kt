package game.findapair.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import game.findapair.presentation.FindAPairViewModel


@Composable
fun CardView(cardIndex: Int, imageId: Int, viewModel: FindAPairViewModel) {

    val isSelected = viewModel.selectedCard.collectAsState().value?.first == cardIndex
    val isMatched = viewModel.matchedCards.collectAsState().value.any { it.first == cardIndex }

    Card(
        modifier = Modifier
            .padding(2.dp)
            .size(64.dp)
            .background(color = Color.Transparent, shape = RoundedCornerShape(9.dp))
            .then(if (isSelected) Modifier.graphicsLayer { alpha = 0.6f } else Modifier)
            .clickable {
                viewModel.selectCard(cardIndex, imageId)
            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (!isMatched) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = "Card Image",
                    /*modifier = if (isSelected) Modifier.graphicsLayer { alpha = 0.6f } else Modifier*/

                )
            }
        }
    }
}


