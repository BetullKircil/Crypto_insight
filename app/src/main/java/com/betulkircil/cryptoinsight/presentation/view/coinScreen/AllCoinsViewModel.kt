package com.betulkircil.cryptoinsight.presentation.view.coinScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.cryptoinsight.domain.useCase.coinsUseCase.getCoinUseCase
import com.betulkircil.cryptoinsight.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AllCoinsViewModel @Inject constructor(
    private val getCoinUseCase: getCoinUseCase
) : ViewModel(){
    private val _state = mutableStateOf(CoinsState())
    val state: State<CoinsState> = _state

    init {
        getCoins(currencyString = _state.value.currency)
    }
    private var job : Job? = null

    private fun getCoins(currencyString: String){
        job?.cancel()
        job = getCoinUseCase.getCoin(currencyString).onEach {result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinsState(coins = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = CoinsState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinsState(error = result.message ?: "An unexpected error occured")
                }
            }

        }.launchIn(viewModelScope)
    }

    fun onEvent(event: CoinsEvent){
        when(event){
            is CoinsEvent.currency -> {
                getCoins(event.currency)
            }
        }
    }
}