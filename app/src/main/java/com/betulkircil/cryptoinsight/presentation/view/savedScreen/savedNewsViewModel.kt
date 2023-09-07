package com.betulkircil.cryptoinsight.presentation.view.savedScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.cryptoinsight.domain.model.NewsModel
import com.betulkircil.cryptoinsight.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedNewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel(){
    private val _savedNewsFlow = MutableStateFlow<List<NewsModel>>(emptyList())
    val savedNewsFlow: StateFlow<List<NewsModel>> = _savedNewsFlow

    init {
        viewModelScope.launch {
            newsRepository.getSavedNews()
                .collect { savedNews ->
                    _savedNewsFlow.value = savedNews
                }
        }
    }

    fun saveFavoriteNews(news: NewsModel) = viewModelScope.launch {
        newsRepository.upsert(news)
    }

    fun getSavedNews() = newsRepository.getSavedNews()

    fun deleteSavedNews(news: NewsModel) = viewModelScope.launch {
        newsRepository.deleteSavedNews(news)
    }
}