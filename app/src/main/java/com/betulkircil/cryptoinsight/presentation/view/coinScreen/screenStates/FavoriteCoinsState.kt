package com.betulkircil.cryptoinsight.presentation.view.coinScreen.screenStates

import com.betulkircil.cryptoinsight.domain.model.FavoriteCoinsModel

data class FavoriteCoinsState(
    val isLoading : Boolean = false,
    val favoriteCoins : List<FavoriteCoinsModel> = emptyList(),
    val error : String = ""
)
