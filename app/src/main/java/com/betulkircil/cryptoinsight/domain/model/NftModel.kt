package com.betulkircil.cryptoinsight.domain.model

data class NftModel(
    val asset_platform_id: String,
    val contract_address: String,
    val id: String,
    val name: String,
    val symbol: String
)
