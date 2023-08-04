package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.data.remote.dto.Item

interface FavoriteCoinsRepository {
    suspend fun getFavoriteCoins() : List<Item>
}