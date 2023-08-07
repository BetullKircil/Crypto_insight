package com.betulkircil.cryptoinsight.domain.model

import com.betulkircil.cryptoinsight.data.remote.dto.Source

data class News(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)
