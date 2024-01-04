package game.findapair.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import game.findapair.ui.screens.imageIds
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FindAPairViewModel() : ViewModel() {
    private val _matchedCards = MutableStateFlow<List<Pair<Int, Int>>>(emptyList())
    val matchedCards: StateFlow<List<Pair<Int, Int>>> = _matchedCards.asStateFlow()

    private val _selectedCard = MutableStateFlow<Pair<Int, Int>?>(null)
    val selectedCard: StateFlow<Pair<Int, Int>?> = _selectedCard.asStateFlow()

    private val _currency = MutableStateFlow(0)
    val currency: StateFlow<Int> = _currency.asStateFlow()

    fun addCurrency(amount: Int) {
        _currency.value += amount
    }

    fun calculateReward(remainingTime: Int) {
        val totalTime = 60
        val maxTime = 20
        val maxReward = 100
        val minReward = 10
        val penaltyPerSecond = 5

        val timeSpent = totalTime - remainingTime
        val reward = if (timeSpent <= maxTime) {
            maxReward
        } else {
            (maxReward - (timeSpent - maxTime) * penaltyPerSecond).coerceAtLeast(minReward)
        }
        addCurrency(reward)
    }

    fun selectCard(cardIndex: Int, imageId: Int) {
        val currentSelection = _selectedCard.value
        if (currentSelection == null) {
            _selectedCard.value = Pair(cardIndex, imageId)
        } else {
            if (currentSelection.second == imageId) {
                _matchedCards.value = _matchedCards.value + listOf(currentSelection, Pair(cardIndex, imageId))
                Log.d("MatchedCards", "Matched cards: ${_matchedCards.value.size}, Total Cards: ${imageIds.size}")
                _selectedCard.value = null
            } else {
                _selectedCard.value = null
            }
        }
    }

    fun isGameCompleted(): Boolean {
        return matchedCards.value.size >= imageIds.size * 2
    }

    fun resetGame() {
        _matchedCards.value = emptyList()
        _selectedCard.value = null
    }
}