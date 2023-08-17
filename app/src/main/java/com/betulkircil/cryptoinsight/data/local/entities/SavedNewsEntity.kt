package com.betulkircil.cryptoinsight.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "newsTable")
data class SavedNewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val description: String,
    val publishedAt: String,
    val title: String?,
    val url: String,
    val urlToImage: String?
) : Serializable
