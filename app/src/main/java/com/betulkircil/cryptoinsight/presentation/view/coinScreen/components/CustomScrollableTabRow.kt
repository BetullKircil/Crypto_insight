package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.NftScreen.NftScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseScreen.ExchangesScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseScreen.GamingNewsScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseScreen.MetaverseNewsScreen

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CustomScrollableTabRow(
    navController: NavController
) {
    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
        var selectedTabIndex by remember { mutableIntStateOf(0) }
        val tabs = listOf(
            "Favorites",
            "All",
            "Metaverse",
            "Gaming",
            "Defi",
            "Innovation",
            "NFT"
        )
        TabRow(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
        ) { tabIndex ->
            selectedTabIndex = tabIndex
        }
         Column(modifier = Modifier
             .fillMaxSize()) {
                                 when (tabs[selectedTabIndex]) {
                                     "Favorites" -> FavoriteCoinsScreen(navController)
                                     "All" -> AllCoinsScreen()
                                     "Metaverse" -> MetaverseNewsScreen(navController = navController)
                                     "Gaming" -> GamingNewsScreen(navController = navController)
                                     "Defi" -> DefiScreen(navController = navController)
                                     "Innovation" -> AllCoinsScreen()
                                     "NFT" -> NftScreen(navController = navController)
                                 }
                             }
    }
}