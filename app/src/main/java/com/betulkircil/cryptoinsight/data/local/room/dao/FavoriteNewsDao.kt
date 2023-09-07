package com.betulkircil.cryptoinsight.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.betulkircil.cryptoinsight.data.remote.dto.Article
import com.betulkircil.cryptoinsight.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteNewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(news: NewsModel) : Long

    @Delete
    suspend fun deleteFavoriteNews(news: NewsModel)

    @Query("SELECT * FROM savedNews")
    fun getAllFavoriteNews(): Flow<List<NewsModel>>
}