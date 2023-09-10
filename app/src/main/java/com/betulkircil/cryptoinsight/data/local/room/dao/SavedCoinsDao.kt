package com.betulkircil.cryptoinsight.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.betulkircil.cryptoinsight.domain.model.Coins
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedCoinsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(coins: Coins) : Long

    @Delete
    suspend fun deleteFavoriteCoins(coins: Coins)

    @Query("SELECT * FROM savedCoins")
    fun getAllFavoriteCoins(): Flow<List<Coins>>
}