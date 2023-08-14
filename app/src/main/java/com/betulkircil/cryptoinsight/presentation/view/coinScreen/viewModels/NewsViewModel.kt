package com.betulkircil.cryptoinsight.presentation.view.coinScreen.viewModels

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.cryptoinsight.domain.useCase.newsUseCase.getNewsUseCase
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.screenEvents.NewsEvent
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.screenStates.NewsState
import com.betulkircil.cryptoinsight.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: getNewsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(NewsState())
    val state: State<NewsState> = _state

    private var job: Job? = null

    init {
        getNews(_state.value.search)
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getNews(searchString: String) {
        job?.cancel()
        job = getNewsUseCase.getBreakingNews(searchString = searchString).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = NewsState(newsList = it.data ?: emptyList())
                }

                is Resource.Loading -> {
                    _state.value = NewsState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = NewsState(error = it.message ?: "Error")
                }

            }
        }.launchIn(viewModelScope)
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun onEvent(event : NewsEvent){
        when(event){
            is NewsEvent.Search -> {
                getNews(event.searcString)
            }
        }
    }
}