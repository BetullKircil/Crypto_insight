package com.betulkircil.cryptoinsight.presentation.view.savedScreen.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.cryptoinsight.domain.model.Coins
import com.betulkircil.cryptoinsight.domain.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedCoinsViewModel @Inject constructor(
    private val coinRepository: CoinRepository
): ViewModel(){
    private val _savedCoinsFlow = MutableStateFlow<List<Coins>>(emptyList())
    val savedCoinsFlow: StateFlow<List<Coins>> = _savedCoinsFlow

    init {
        viewModelScope.launch {
            coinRepository.getSavedCoins()
                .collect { savedCoins ->
                    _savedCoinsFlow.value = savedCoins
                }
        }
    }

    fun saveFavoriteCoins(coins: Coins) = viewModelScope.launch {
        coinRepository.upsert(coins)
    }

    fun getSavedCoins() = coinRepository.getSavedCoins()

    fun deleteSavedCoins(coins: Coins) = viewModelScope.launch {
        coinRepository.deleteSavedCoins(coins)
    }
}