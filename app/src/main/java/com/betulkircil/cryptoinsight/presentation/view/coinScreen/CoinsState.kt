package com.betulkircil.cryptoinsight.presentation.view.coinScreen

import com.betulkircil.cryptoinsight.domain.model.Coin

data class CoinsState(
    val isLoading : Boolean = false,
    val coins : List<Coin> = emptyList(),
    val error : String = "",
    val currency : String = "eur"
)
