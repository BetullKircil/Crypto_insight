package com.betulkircil.cryptoinsight.data.remote.dto

import com.betulkircil.cryptoinsight.domain.model.FavoriteCoinsModel

data class Item(
    val coin_id: Int,
    val id: String,
    val large: String,
    val market_cap_rank: Int,
    val name: String,
    val price_btc: Double,
    val score: Int,
    val slug: String,
    val small: String,
    val symbol: String,
    val thumb: String
)


fun Item.toFavorites() : FavoriteCoinsModel{
    return FavoriteCoinsModel(
        name = name,
        market_cap_rank = market_cap_rank,
        price_btc = price_btc,
        small = small,
        symbol = symbol
    )
}