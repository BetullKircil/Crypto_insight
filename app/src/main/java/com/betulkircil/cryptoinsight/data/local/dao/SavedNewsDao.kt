package com.betulkircil.cryptoinsight.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.betulkircil.cryptoinsight.data.local.entities.SavedNewsEntity
import kotlinx.coroutines.flow.Flow

interface SavedNewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article:SavedNewsEntity) :Long

    @Query("SELECT * FROM newsTable")
    fun getSavedNews(): Flow<List<SavedNewsEntity>>

    @Delete
    suspend fun deleteArticle(savedNews : SavedNewsEntity)
}