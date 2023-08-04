package com.betulkircil.cryptoinsight.data.remote.dto

data class FavotitesDto(
    val coins: List<Coin>,
    val exchanges: List<Any>,
    val nfts: List<Nft>
)