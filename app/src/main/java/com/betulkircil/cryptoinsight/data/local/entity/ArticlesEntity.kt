package com.betulkircil.cryptoinsight.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.betulkircil.cryptoinsight.data.remote.dto.Source

@Entity(
    tableName = "articles"
)
data class ArticlesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)
