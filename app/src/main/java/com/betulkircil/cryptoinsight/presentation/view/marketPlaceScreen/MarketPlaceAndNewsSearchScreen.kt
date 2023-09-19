package com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BottomNavigationBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsAppBar
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.AppBarContent
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.MarketPlaceScreenContent

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MarketPlaceAndNewsSearchScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = { NewsAppBar(greetingContent = { AppBarContent("News/MarketPlace", R.drawable.marketplace) }) },
        bottomBar = { BottomNavigationBar(navController = navController) },
        content = {
            it
            MarketPlaceScreenContent(navController = navController)
        }
    )
}
