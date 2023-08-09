package com.betulkircil.cryptoinsight.data.remote.dto

import com.betulkircil.cryptoinsight.domain.model.NewsModel

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)

fun News.toNewsModel() :List<NewsModel>{
    return articles.map { article ->
        NewsModel(description = article.description, publishedAt = article.publishedAt, title = article.title, url = article.url, urlToImage = article.urlToImage)
    }
}