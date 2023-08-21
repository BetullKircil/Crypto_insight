package com.betulkircil.cryptoinsight.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.betulkircil.cryptoinsight.data.local.entities.SavedNewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteNewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteNews(news: SavedNewsEntity)

    @Delete
    suspend fun deleteFavoriteNews(news: SavedNewsEntity)

    @Query("SELECT * FROM savedNewsTable")
    fun getAllFavoriteNews(): Flow<List<SavedNewsEntity>>
}