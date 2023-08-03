package com.betulkircil.cryptoinsight.presentation.view.coinScreen

sealed class CoinsEvent{
    data class currency(val currency : String) : CoinsEvent()
}
