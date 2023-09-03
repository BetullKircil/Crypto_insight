package com.betulkircil.cryptoinsight.domain.model

data class ExchangesModel(
    val id: String,
    val image: String,
    val name: String,
    val trade_volume_24h_btc_normalized: Double,
    val url: String,
)
