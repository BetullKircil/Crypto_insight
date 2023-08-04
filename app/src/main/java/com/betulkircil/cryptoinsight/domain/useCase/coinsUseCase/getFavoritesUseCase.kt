package com.betulkircil.cryptoinsight.domain.useCase.coinsUseCase

import com.betulkircil.cryptoinsight.data.remote.dto.toFavorites
import com.betulkircil.cryptoinsight.domain.model.FavoriteCoinsModel
import com.betulkircil.cryptoinsight.domain.repository.FavoriteCoinsRepository
import com.betulkircil.cryptoinsight.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class getFavoritesUseCase @Inject constructor(
    private val favoriteCoinsRepository: FavoriteCoinsRepository
) {
    fun getFavoriteCoins() : Flow<Resource<List<FavoriteCoinsModel>>> = flow {
        try {
            emit(Resource.Loading())
            val favoriteCoins = favoriteCoinsRepository.getFavoriteCoins().map { favoriteCoin ->
                favoriteCoin.toFavorites()
            }
            emit(Resource.Success(favoriteCoins))

        }
        catch (e : Exception){
            emit(Resource.Error(e.localizedMessage?: "Unexpected error"))
        }
        catch (e : IOException){
            emit(Resource.Error("Couldn't reach the server. Check your internet connection"))
        }
    }
}