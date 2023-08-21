package com.betulkircil.cryptoinsight.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.betulkircil.cryptoinsight.data.local.entities.FavoriteNewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteNewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteNews(news: FavoriteNewsEntity)

    @Delete
    suspend fun deleteFavoriteNews(news: FavoriteNewsEntity)

    @Query("SELECT * FROM favoriteNewsTable")
    fun getAllFavoriteNews(): Flow<List<FavoriteNewsEntity>>
}