package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.data.remote.dto.News

interface NewsRepository {
    suspend fun getBreakingNews(searchString: String) : News
    suspend fun getMetaverseNews(metaverseKey: String) : News
    suspend fun getNftNews(nftKey: String) : News
    suspend fun getGamingNews(gamingKey: String) : News
    suspend fun getDefiNews(defiKey: String) : News
    suspend fun getInnovationNews(innovationKey: String) : News
}