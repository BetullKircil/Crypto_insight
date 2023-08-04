package com.betulkircil.cryptoinsight.data.remote.dto

data class Nft(
    val floor_price_24h_percentage_change: Double,
    val floor_price_in_native_currency: Double,
    val id: String,
    val name: String,
    val nft_contract_id: Int,
    val symbol: String,
    val thumb: String
)