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

}