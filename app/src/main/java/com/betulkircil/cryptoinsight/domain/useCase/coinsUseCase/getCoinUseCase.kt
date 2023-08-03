package com.betulkircil.cryptoinsight.domain.useCase.coinsUseCase

import com.betulkircil.cryptoinsight.data.remote.dto.toCoin
import com.betulkircil.cryptoinsight.domain.model.Coin
import com.betulkircil.cryptoinsight.domain.repository.CoinRepository
import com.betulkircil.cryptoinsight.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class getCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    fun getCoin(currencyString : String) : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins(currencyString).map {
                it.toCoin()
            }
            emit(Resource.Success(coins))
        }catch (e : Exception){
            emit(Resource.Error(e.localizedMessage?: "Unexpected error"))
        }
        catch (e : IOException){
            emit(Resource.Error("Couldn't reach the server. Check your internet connection"))
        }
    }
}