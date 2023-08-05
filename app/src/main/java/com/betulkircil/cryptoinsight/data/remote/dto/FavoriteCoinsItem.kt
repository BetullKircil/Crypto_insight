package com.betulkircil.cryptoinsight.data.remote.dto

import com.betulkircil.cryptoinsight.domain.model.FavoriteCoinsModel

data class FavoriteCoinsItem(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun FavoriteCoinsItem.toFavoriteCoin():FavoriteCoinsModel{
    return FavoriteCoinsModel(
        is_active = is_active,
        name = name,
        symbol = symbol
    )
}