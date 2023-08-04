package com.betulkircil.cryptoinsight.presentation.view.coinScreen.screenEvents

sealed class CoinsEvent{
    data class currency(val currency : String) : CoinsEvent()
}
