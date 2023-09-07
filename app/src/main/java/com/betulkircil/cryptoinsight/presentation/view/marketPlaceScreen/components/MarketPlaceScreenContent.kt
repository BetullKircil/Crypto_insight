package com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.TabRowContent
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.MarketPlaceAndNewsSearchScreen

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MarketPlaceScreenContent(navController: NavController) {
    var tabIndex = remember { mutableIntStateOf(0) }
    val tabs = listOf("News", "MarketPlace")
    TabRowContent(firstTab = "News", secondTab = "MarketPlace", navController = navController, tabs = tabs, tabIndex = tabIndex,
        { NewsLazyStaggeredVerticalGrid(navController) },
        { CoinMarketPlaceScreen(navController = navController) })
}