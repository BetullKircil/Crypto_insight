package com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen.components

import androidx.annotation.DrawableRes
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)

val pages = listOf<Page>(
    Page(
        title = "Welcome",
        description = "Explore the latest in crypto and blockchain news, track your favorite coins, and stay ahead in the world of digital currencies.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Stay Informed",
        description = "Discover up-to-date news articles covering the dynamic world of cryptocurrencies and blockchain technology. Save, share, and come back to your favorite stories.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Manage Your Portfolio",
        description = "Keep an eye on the crypto market. Add and track your preferred coins in your personal watchlist for easy monitoring.",
        image = R.drawable.onboarding3
    )
)
