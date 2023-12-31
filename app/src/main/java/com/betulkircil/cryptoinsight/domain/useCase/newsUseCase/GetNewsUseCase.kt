package com.betulkircil.cryptoinsight.domain.useCase.newsUseCase

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.betulkircil.cryptoinsight.data.remote.dto.toNewsModel
import com.betulkircil.cryptoinsight.domain.model.NewsModel
import com.betulkircil.cryptoinsight.domain.repository.NewsRepository
import com.betulkircil.cryptoinsight.utils.Resource
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class getNewsUseCase @Inject constructor(
    private val repository : NewsRepository
){
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getBreakingNews(key: String) : kotlinx.coroutines.flow.Flow<Resource<List<NewsModel>>>{
        return flow {
            try {
                emit(Resource.Loading())
                val news =  repository.getBreakingNews(key)
                emit(Resource.Success(news.toNewsModel()))
            }
            catch (e : IOError){
                emit(Resource.Error(message = "No internet connection"))
            }
            catch (e : HttpException){
                emit(Resource.Error(message = e.localizedMessage ?: "Error"))
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getMetaverseNews(metaverseKey: String) : kotlinx.coroutines.flow.Flow<Resource<List<NewsModel>>>{
        return flow {
            try {
                emit(Resource.Loading())
                val news =  repository.getBreakingNews(metaverseKey)
                emit(Resource.Success(news.toNewsModel()))
            }
            catch (e : IOError){
                emit(Resource.Error(message = "No internet connection"))
            }
            catch (e : HttpException){
                emit(Resource.Error(message = e.localizedMessage ?: "Error"))
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getDefiNews(defiKey: String) : kotlinx.coroutines.flow.Flow<Resource<List<NewsModel>>>{
        return flow {
            try {
                emit(Resource.Loading())
                val news =  repository.getBreakingNews(defiKey)
                emit(Resource.Success(news.toNewsModel()))
            }
            catch (e : IOError){
                emit(Resource.Error(message = "No internet connection"))
            }
            catch (e : HttpException){
                emit(Resource.Error(message = e.localizedMessage ?: "Error"))
            }
        }
    }
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getGamingNews(gamingKey: String) : kotlinx.coroutines.flow.Flow<Resource<List<NewsModel>>>{
        return flow {
            try {
                emit(Resource.Loading())
                val news =  repository.getBreakingNews(gamingKey)
                emit(Resource.Success(news.toNewsModel()))
            }
            catch (e : IOError){
                emit(Resource.Error(message = "No internet connection"))
            }
            catch (e : HttpException){
                emit(Resource.Error(message = e.localizedMessage ?: "Error"))
            }
        }
    }
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getInnovationNews(innovationKey: String) : kotlinx.coroutines.flow.Flow<Resource<List<NewsModel>>>{
        return flow {
            try {
                emit(Resource.Loading())
                val news =  repository.getBreakingNews(innovationKey)
                emit(Resource.Success(news.toNewsModel()))
            }
            catch (e : IOError){
                emit(Resource.Error(message = "No internet connection"))
            }
            catch (e : HttpException){
                emit(Resource.Error(message = e.localizedMessage ?: "Error"))
            }
        }
    }
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getNftNews(nftKey: String) : kotlinx.coroutines.flow.Flow<Resource<List<NewsModel>>>{
        return flow {
            try {
                emit(Resource.Loading())
                val news =  repository.getBreakingNews(nftKey)
                emit(Resource.Success(news.toNewsModel()))
            }
            catch (e : IOError){
                emit(Resource.Error(message = "No internet connection"))
            }
            catch (e : HttpException){
                emit(Resource.Error(message = e.localizedMessage ?: "Error"))
            }
        }
    }
}
