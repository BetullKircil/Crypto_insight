package com.betulkircil.cryptoinsight.domain.model

data class Coin(
    val image: String,
    val id: String,
    val symbol: String,
    val name: String,
    val currentPrice: Double,
    val marketCapChange24: Double
)
