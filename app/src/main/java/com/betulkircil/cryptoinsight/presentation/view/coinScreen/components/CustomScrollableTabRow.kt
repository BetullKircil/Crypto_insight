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
import com.betulkircil.cryptoinsight.presentation.view.metaverseNewsScreen.DefiNewsScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseNewsScreen.GamingNewsScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseNewsScreen.InnovationNewsScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseNewsScreen.MetaverseNewsScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseNewsScreen.NftNewsScreen

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
                                     tabs[0] -> FavoriteCoinsScreen(navController)
                                     tabs[1] -> AllCoinsScreen()
                                     tabs[2] -> MetaverseNewsScreen(navController = navController)
                                     tabs[3] -> GamingNewsScreen(navController = navController)
                                     tabs[4] -> DefiNewsScreen(navController = navController)
                                     tabs[5] -> InnovationNewsScreen(navController = navController)
                                     tabs[6] -> NftNewsScreen(navController = navController)
                                 }
                             }
    }
}