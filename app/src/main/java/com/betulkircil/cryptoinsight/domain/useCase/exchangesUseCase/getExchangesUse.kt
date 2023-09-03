package com.betulkircil.cryptoinsight.domain.useCase.exchangesUseCase

import com.betulkircil.cryptoinsight.data.remote.dto.toCoin
import com.betulkircil.cryptoinsight.data.remote.dto.toExchangesModel
import com.betulkircil.cryptoinsight.domain.model.Coins
import com.betulkircil.cryptoinsight.domain.model.ExchangesModel
import com.betulkircil.cryptoinsight.domain.repository.ExchangesRepository
import com.betulkircil.cryptoinsight.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class getExchangesUse @Inject constructor(
    private val repository: ExchangesRepository
) {
    fun getExchanges() : Flow<Resource<List<ExchangesModel>>> = flow {
        try {
            emit(Resource.Loading())
            val exchanges = repository.getExchanges().map {
                it.toExchangesModel()
            }
            emit(Resource.Success(exchanges))
        }catch (e : Exception){
            emit(Resource.Error(e.localizedMessage?: "Unexpected error"))
        }
        catch (e : IOException){
            emit(Resource.Error("Couldn't reach the server. Check your internet connection"))
        }
    }
}