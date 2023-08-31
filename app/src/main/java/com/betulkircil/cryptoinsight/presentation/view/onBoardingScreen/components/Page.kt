package com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen.components

import androidx.annotation.DrawableRes
import com.betulkircil.cryptoinsight.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)

val pages = listOf<Page>(
    Page(
        title = "title1",
        description = "description1",
        image = R.drawable.moon
    ),
    Page(
        title = "title2",
        description = "description2",
        image = R.drawable.noon
    ),
    Page(
        title = "title3",
        description = "description3",
        image = R.drawable.profile_clicked
    )
)
