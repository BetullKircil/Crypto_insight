package com.betulkircil.cryptoinsight.domain.model

data class NewsModel(
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String?
)
