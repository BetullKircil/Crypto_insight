package com.betulkircil.cryptoinsight.presentation.view.coinScreen.screenStates

import com.betulkircil.cryptoinsight.domain.model.NewsModel

data class NewsState(
    val isLoading : Boolean = false,
    val newsList : List<NewsModel> = emptyList(),
    val error : String = "",
    val search : String = "crypto"
)
