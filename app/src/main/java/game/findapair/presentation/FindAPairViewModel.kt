package game.findapair.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FindAPairViewModel() : ViewModel() {
    private val _matchedCards = MutableStateFlow<List<Pair<Int, Int>>>(emptyList())
    val matchedCards: StateFlow<List<Pair<Int, Int>>> = _matchedCards.asStateFlow()

    private val _selectedCard = MutableStateFlow<Pair<Int, Int>?>(null)
    val selectedCard: StateFlow<Pair<Int, Int>?> = _selectedCard.asStateFlow()

    var currency: Int = 0
        private set

    fun changeCurrency() {

    }

    fun selectCard(cardIndex: Int, imageId: Int) {
        val currentSelection = _selectedCard.value
        if (currentSelection == null) {
            _selectedCard.value = Pair(cardIndex, imageId)
        } else {
            if (currentSelection.second == imageId) {
                _matchedCards.value = _matchedCards.value + listOf(currentSelection, Pair(cardIndex, imageId))
                _selectedCard.value = null
            } else {
                _selectedCard.value = null
            }
        }
    }
}