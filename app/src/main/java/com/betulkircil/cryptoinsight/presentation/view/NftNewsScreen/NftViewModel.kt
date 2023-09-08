package com.betulkircil.cryptoinsight.presentation.view.NftNewsScreen

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
class NftViewModel @Inject constructor(
    private val getNewsUseCase: getNewsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(NewsState())
    val state: State<NewsState> = _state

    private var job: Job? = null

    init {
        getNftNews(_state.value.nft)
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getNftNews(nftKey: String) {
        job?.cancel()
        job = getNewsUseCase.getBreakingNews(key = nftKey).onEach {
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
            is NewsEvent.All -> {
                getNftNews(event.allNews)
            }
            is NewsEvent.Defi -> {
                getNftNews(event.defiNews)
            }
            is NewsEvent.Gaming -> {
                getNftNews(event.gamingNews)
            }
            is NewsEvent.Nft -> {
                getNftNews(event.nftNews)
            }
            is NewsEvent.Innovation -> {
                getNftNews(event.innovationNews)
            }
            is NewsEvent.Metaverse -> {
                getNftNews(event.metaverseNews)
            }
        }
    }
}