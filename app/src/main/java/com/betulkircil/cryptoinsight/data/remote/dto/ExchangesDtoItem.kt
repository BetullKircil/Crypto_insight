package com.betulkircil.cryptoinsight.data.remote.dto

import com.betulkircil.cryptoinsight.domain.model.Coins
import com.betulkircil.cryptoinsight.domain.model.ExchangesModel

data class ExchangesDtoItem(
    val country: String,
    val description: String,
    val has_trading_incentive: Boolean,
    val id: String,
    val image: String,
    val name: String,
    val trade_volume_24h_btc: Double,
    val trade_volume_24h_btc_normalized: Double,
    val trust_score: Int,
    val trust_score_rank: Int,
    val url: String,
    val year_established: Int
)

fun ExchangesDtoItem.toExchangesModel() : ExchangesModel {
    return ExchangesModel(
        id = id,
        image = image,
        name = name,
        trade_volume_24h_btc_normalized = trade_volume_24h_btc_normalized,
        url = url
    )
}