package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.data.remote.dto.CoinsDtoItem
import com.betulkircil.cryptoinsight.domain.model.Coins
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    suspend fun getCoins(currencyString : String) : List<CoinsDtoItem>
    suspend fun upsert(coins : Coins): Long
    fun getSavedCoins() : Flow<List<Coins>>
    suspend fun deleteSavedCoins(coins : Coins)
}