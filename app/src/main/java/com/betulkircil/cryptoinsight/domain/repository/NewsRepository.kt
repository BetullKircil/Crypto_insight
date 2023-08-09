package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.data.remote.dto.News

interface NewsRepository {
    suspend fun getBreakingNews(searchString: String) : News
}