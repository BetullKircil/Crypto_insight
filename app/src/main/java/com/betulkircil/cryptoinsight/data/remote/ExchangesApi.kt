package com.betulkircil.cryptoinsight.data.remote

import com.betulkircil.cryptoinsight.data.remote.dto.ExchangesDtoItem
import com.betulkircil.cryptoinsight.utils.Constants.EXCHANGES_END_POINT
import retrofit2.http.GET

interface ExchangesApi {
    @GET(EXCHANGES_END_POINT)
    suspend fun getExchanges() : List<ExchangesDtoItem>
}