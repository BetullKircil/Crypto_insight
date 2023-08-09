package com.betulkircil.cryptoinsight.presentation.view.coinScreen.screenEvents

sealed class NewsEvent{
    data class Search(val searcString: String) : NewsEvent()
}
