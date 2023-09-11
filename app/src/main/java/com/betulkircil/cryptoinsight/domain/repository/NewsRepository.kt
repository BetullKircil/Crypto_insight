package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.data.remote.dto.News
import com.betulkircil.cryptoinsight.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getBreakingNews(searchString: String) : News
    suspend fun getMetaverseNews(metaverseKey: String) : News
    suspend fun getNftNews(nftKey: String) : News
    suspend fun getGamingNews(gamingKey: String) : News
    suspend fun getDefiNews(defiKey: String) : News
    suspend fun getInnovationNews(innovationKey: String) : News
    suspend fun upsert(news : NewsModel): Long
    fun getSavedNews() : Flow<List<NewsModel>>
    suspend fun deleteSavedNews(news : NewsModel)
}