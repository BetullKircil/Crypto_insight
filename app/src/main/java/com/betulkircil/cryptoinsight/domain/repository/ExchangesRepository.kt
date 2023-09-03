package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.data.remote.dto.ExchangesDtoItem

interface ExchangesRepository {
    suspend fun getExchanges() : List<ExchangesDtoItem>
}