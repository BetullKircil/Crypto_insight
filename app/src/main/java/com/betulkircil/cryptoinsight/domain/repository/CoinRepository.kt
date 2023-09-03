package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.data.remote.dto.CoinsDtoItem

interface CoinRepository {
    suspend fun getCoins(currencyString : String) : List<CoinsDtoItem>
}