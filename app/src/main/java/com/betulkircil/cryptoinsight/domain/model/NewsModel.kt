package com.betulkircil.cryptoinsight.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "savedNews"
)
data class NewsModel(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable
