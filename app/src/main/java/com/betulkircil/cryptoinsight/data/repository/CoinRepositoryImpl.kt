package com.betulkircil.cryptoinsight.data.repository

import com.betulkircil.cryptoinsight.data.remote.CoinsApi
import com.betulkircil.cryptoinsight.data.remote.dto.CoinsDtoItem
import com.betulkircil.cryptoinsight.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinsApi: CoinsApi
): CoinRepository {
    override suspend fun getCoins(currencyString: String): List<CoinsDtoItem> {
        return  coinsApi.getCoins(currencyString)
    }
}