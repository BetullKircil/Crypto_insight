package com.betulkircil.cryptoinsight.data.repository

import com.betulkircil.cryptoinsight.data.local.room.db.FavoriteCoinsDatabase
import com.betulkircil.cryptoinsight.data.local.room.db.FavoriteNewsDatabase
import com.betulkircil.cryptoinsight.data.remote.CoinsApi
import com.betulkircil.cryptoinsight.data.remote.dto.CoinsDtoItem
import com.betulkircil.cryptoinsight.domain.model.Coins
import com.betulkircil.cryptoinsight.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinsApi: CoinsApi,
    private val coinsDb: FavoriteCoinsDatabase
): CoinRepository {
    override suspend fun getCoins(currencyString: String): List<CoinsDtoItem> {
        return  coinsApi.getCoins(currencyString)
    }

    override suspend fun upsert(coins: Coins): Long {
        return coinsDb.getFavoriteCoinsDao().upsert(coins)
    }

    override fun getSavedCoins(): Flow<List<Coins>> {
        return coinsDb.getFavoriteCoinsDao().getAllFavoriteCoins()
    }

    override suspend fun deleteSavedCoins(coins: Coins) {
        return coinsDb.getFavoriteCoinsDao().deleteFavoriteCoins(coins)
    }
}