package com.betulkircil.cryptoinsight.presentation.view.coinScreen.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.cryptoinsight.domain.useCase.coinsUseCase.getFavoritesUseCase
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.screenStates.FavoriteCoinsState
import com.betulkircil.cryptoinsight.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoriteCoinsViewModel @Inject constructor(
    private val getFavoritesUseCase: getFavoritesUseCase
) : ViewModel(){
    private val _state = mutableStateOf(FavoriteCoinsState())
    val state : State<FavoriteCoinsState> = _state


    private fun getFavoriteCoins(){
        getFavoritesUseCase.getFavoriteCoins().onEach {result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = FavoriteCoinsState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FavoriteCoinsState(favoriteCoins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = FavoriteCoinsState(error = result.message ?: "Unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}