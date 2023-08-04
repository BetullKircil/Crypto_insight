package com.betulkircil.cryptoinsight.data.repository

import com.betulkircil.cryptoinsight.data.remote.FavoriteCoinsApi
import com.betulkircil.cryptoinsight.data.remote.dto.Item
import com.betulkircil.cryptoinsight.domain.repository.FavoriteCoinsRepository
import javax.inject.Inject

class FavoriteCoinsRepositoryImpl @Inject constructor(
    private val favoriteCoinsApi: FavoriteCoinsApi
) : FavoriteCoinsRepository{
    override suspend fun getFavoriteCoins(): List<Item> {
        return favoriteCoinsApi.getFavoriteCoins()
    }
}