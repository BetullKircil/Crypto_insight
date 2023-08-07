package com.betulkircil.cryptoinsight.data.remote.dto

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)