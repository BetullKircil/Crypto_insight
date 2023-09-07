package com.betulkircil.cryptoinsight.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "savedCoins"
)
data class Coins(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val image: String,
    val symbol: String,
    val name: String,
    val currentPrice: Double,
    val marketCapChange24Percentage: Double
): Serializable
