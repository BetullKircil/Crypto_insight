package com.betulkircil.cryptoinsight.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "favoriteNewsTable")
data class FavoriteNewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "description") @NotNull
    val description: String,
    @ColumnInfo(name = "publishedAt") @NotNull
    val publishedAt: String,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "url") @NotNull
    val url: String,
    @ColumnInfo(name = "urlToImage")
    val urlToImage: String?
)
