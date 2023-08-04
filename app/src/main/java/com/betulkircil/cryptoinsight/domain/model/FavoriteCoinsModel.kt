package com.betulkircil.cryptoinsight.domain.model

data class FavoriteCoinsModel(
    val name: String,
    val price_btc: Double,
    val market_cap_rank: Int,
    val small: String,
    val symbol: String,
)
