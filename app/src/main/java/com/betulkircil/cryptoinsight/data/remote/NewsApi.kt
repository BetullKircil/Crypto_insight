package com.betulkircil.cryptoinsight.data.remote

import com.betulkircil.cryptoinsight.data.remote.dto.Article
import com.betulkircil.cryptoinsight.data.remote.dto.News
import com.betulkircil.cryptoinsight.utils.Constants.API_KEY
import com.betulkircil.cryptoinsight.utils.Constants.NEWS_END_POINT
import com.betulkircil.cryptoinsight.utils.Constants.SEARCH_NEWS_END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET(NEWS_END_POINT)
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ) : Response<News>

    @GET(SEARCH_NEWS_END_POINT)
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ) : Response<News>
}