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
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.HomeScreen
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginScreen
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.NewsLazyStaggeredVerticalGrid

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
                                     "All" -> AllCoinsScreen(navController = navController)
                                     "Metaverse" -> NewsRowScreen(navController)
                                     "Gaming" -> NewsLazyStaggeredVerticalGrid(navController = navController)
                                     "Defi" -> HomeScreen(navController = navController)
                                     "Innovation" -> LoginScreen(navController = navController)
                                     "NFT" -> NftScreen(navController = navController)
                                 }
                             }
      /*  LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(1) { index ->
                Box(modifier = Modifier.fillMaxSize()) {
                    when (tabs[selectedTabIndex]) {
                        "Favorites" -> LoginScreen(navController = navController)
                        "All" -> AllCoinsScreen(navController = navController)
                        "Metaverse" -> SignUpNameScreen(navController)
                        "Gaming" -> LoginScreen(navController = navController)
                        "Defi" -> HomeScreen(navController = navController)
                        "Innovation" -> LoginScreen(navController = navController)
                        "NFT" -> HomeScreen(navController = navController)
                    }
                }
            }
        }*/
    }
}