package com.betulkircil.cryptoinsight.presentation.view.coinScreen.screenStates

import com.betulkircil.cryptoinsight.domain.model.Coins

data class CoinsState(
    val isLoading : Boolean = false,
    val coins : List<Coins> = emptyList(),
    val error : String = "",
    val currency : String = "eur"
)
