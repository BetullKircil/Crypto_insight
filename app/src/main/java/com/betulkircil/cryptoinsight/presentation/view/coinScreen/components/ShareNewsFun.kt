package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import android.content.Context
import android.content.Intent
import com.betulkircil.cryptoinsight.domain.model.NewsModel

fun shareNews(news: NewsModel, context : Context) {
    val shareText = "${news.title}\n\n${news.description}\n\n${news.url}"

    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, shareText)
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)
    context.startActivity(shareIntent)
}