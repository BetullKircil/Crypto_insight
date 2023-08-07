package com.betulkircil.cryptoinsight.utils


//https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur  coins api
//https://newsapi.org/v2/everything?q=cryptoCurrency&from=2023-07-07&sortBy=publishedAt&apiKey=0685e2c571b9424cb002c1a1ced2ee42
object Constants {
    const val COIN_BASE_URL = "https://api.coingecko.com/api/v3/"
    const val COIN_END_POINT = "coins/markets"
    const val API_KEY = "0685e2c571b9424cb002c1a1ced2ee42"
    const val NEWS_BASE_URL = "https://newsapi.org/"
    const val NEWS_END_POINT = "v2/top-headlines"
    const val SEARCH_NEWS_END_POINT = "v2/everything"
}