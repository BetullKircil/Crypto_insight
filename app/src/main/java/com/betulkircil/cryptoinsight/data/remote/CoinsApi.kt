package com.betulkircil.cryptoinsight.data.remote

import com.betulkircil.cryptoinsight.data.remote.dto.CoinsDtoItem
import com.betulkircil.cryptoinsight.utils.Constants.COIN_END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinsApi {
    @GET(COIN_END_POINT)
    suspend fun getCoins(
        @Query("vs_currency") coinType : String
    ) : List<CoinsDtoItem>
}