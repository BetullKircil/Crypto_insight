package com.betulkircil.cryptoinsight.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.betulkircil.cryptoinsight.data.local.entity.ArticlesEntity

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(articlesEntity: ArticlesEntity) : Long

    @Query("SELECT * FROM articles")
    fun getAllArticles() : LiveData<List<ArticlesEntity>>

    @Delete
    suspend fun deleteArticle(articlesEntity: ArticlesEntity)

}