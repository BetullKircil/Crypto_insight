package com.betulkircil.cryptoinsight.data.remote

import com.betulkircil.cryptoinsight.data.remote.dto.Item
import com.betulkircil.cryptoinsight.utils.Constants.FAVORITES_END_POINT
import retrofit2.http.GET

interface FavoriteCoinsApi {
    @GET(FAVORITES_END_POINT)
    suspend fun getFavoriteCoins() : List<Item>
}