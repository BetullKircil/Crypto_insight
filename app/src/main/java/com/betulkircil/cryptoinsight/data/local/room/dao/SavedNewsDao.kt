package com.betulkircil.cryptoinsight.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.betulkircil.cryptoinsight.data.local.entities.SavedNewsEntity

@Dao
interface SavedNewsDao {
    @Query("SELECT * FROM savedNewsTable")
    suspend fun getAllSavedNews(): List<SavedNewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNews(savedNewsEntity: SavedNewsEntity) : Long

    @Delete
    suspend fun deleteNews(savedNewsEntity: SavedNewsEntity)
}