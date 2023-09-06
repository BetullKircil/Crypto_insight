package com.betulkircil.cryptoinsight.data.repository

import com.betulkircil.cryptoinsight.data.local.entities.FavoriteNewsEntity
import com.betulkircil.cryptoinsight.data.local.room.dao.FavoriteNewsDao
import com.betulkircil.cryptoinsight.data.remote.NewsApi
import com.betulkircil.cryptoinsight.data.remote.dto.Article
import com.betulkircil.cryptoinsight.data.remote.dto.News
import com.betulkircil.cryptoinsight.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
) :NewsRepository{
    override suspend fun getBreakingNews(searchString: String): News {
        return newsApi.getBreakingNews(searchString = searchString)
    }

    override suspend fun getMetaverseNews(metaverseKey: String): News {
        return newsApi.getBreakingNews(searchString = metaverseKey)
    }

    override suspend fun getNftNews(nftKey: String): News {
        return newsApi.getBreakingNews(searchString =  nftKey)
    }

    override suspend fun getGamingNews(gamingKey: String): News {
        return newsApi.getBreakingNews(searchString = gamingKey)
    }

    override suspend fun getDefiNews(defiKey: String): News {
        return newsApi.getBreakingNews(searchString = defiKey)
    }

    override suspend fun getInnovationNews(innovationKey: String): News {
        return newsApi.getBreakingNews(searchString = innovationKey)
    }

}