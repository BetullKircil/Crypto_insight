package com.betulkircil.cryptoinsight.presentation.view.coinScreen.screenEvents

sealed class NewsEvent{
    data class All(val allNews: String) : NewsEvent()
    data class Metaverse(val metaverseNews: String) : NewsEvent()
    data class Gaming(val gamingNews: String) : NewsEvent()
    data class Defi(val defiNews: String) : NewsEvent()
    data class Innovation(val innovationNews: String) : NewsEvent()
    data class Nft(val nftNews: String) : NewsEvent()
}
