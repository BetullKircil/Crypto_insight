package com.betulkircil.cryptoinsight.data.remote

import com.betulkircil.cryptoinsight.data.remote.dto.News
import com.betulkircil.cryptoinsight.utils.Constants.API_KEY
import com.betulkircil.cryptoinsight.utils.Constants.NEWS_END_POINT
import retrofit2.http.GET
import retrofit2.http.Query
//https://newsapi.org/v2/everything?q=cryptoCurrency&sortBy=publishedAt&apiKey=0685e2c571b9424cb002c1a1ced2ee42

interface NewsApi {
    @GET(NEWS_END_POINT)
    suspend fun getBreakingNews(
        @Query("q")
        searchString: String,
        @Query("sortBy")
        sortString: String = "publishedAt",
        @Query("apiKey")
        apiKey: String = API_KEY
    ) : News

}