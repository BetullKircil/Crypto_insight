package com.betulkircil.cryptoinsight.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsTable")
data class SavedNewsEntity(
    @PrimaryKey val id : String,
    val description: String,
    val publishedAt: String,
    val title: String?,
    val url: String,
    val urlToImage: String?
)
