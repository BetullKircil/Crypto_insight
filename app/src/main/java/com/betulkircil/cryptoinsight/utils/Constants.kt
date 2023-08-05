package com.betulkircil.cryptoinsight.utils


//https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur  coins api
//https://api.coingecko.com/api/v3/search/trending    favorites api
//https://api.coingecko.com/api/v3/nfts/list
//https://api.coinpaprika.com/v1/coins
object Constants {
    const val COIN_BASE_URL = "https://api.coingecko.com/api/v3/"
    const val COIN_END_POINT = "coins/markets"
    const val FAVORITES_BASE_URL = "https://api.coinpaprika.com/"
    const val FAVORITES_END_POINT = "v1/coins"
   // const val FAVORITES_END_POINT = "search/trending"
    const val NFT_BASE_URL = "https://api.coingecko.com/api/v3/"
    const val NFT_END_POINT = "nfts/list"
}