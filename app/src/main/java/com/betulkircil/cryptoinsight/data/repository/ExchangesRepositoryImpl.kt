package com.betulkircil.cryptoinsight.data.repository

import com.betulkircil.cryptoinsight.data.remote.ExchangesApi
import com.betulkircil.cryptoinsight.data.remote.dto.ExchangesDtoItem
import com.betulkircil.cryptoinsight.domain.repository.ExchangesRepository
import javax.inject.Inject

class ExchangesRepositoryImpl @Inject constructor(
    private val exchangesApi : ExchangesApi
): ExchangesRepository{
    override suspend fun getExchanges(): List<ExchangesDtoItem> {
        return exchangesApi.getExchanges()
    }
}