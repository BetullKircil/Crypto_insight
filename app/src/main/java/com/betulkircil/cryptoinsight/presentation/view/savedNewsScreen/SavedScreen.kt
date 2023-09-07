package com.betulkircil.cryptoinsight.presentation.view.savedNewsScreen

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BottomNavigationBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsAppBar
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.AppBarContent
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.CoinMarketPlaceScreen
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.NewsLazyStaggeredVerticalGrid
import com.betulkircil.cryptoinsight.presentation.view.savedNewsScreen.components.SavedNewsScreen

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun SavedScreen(
    navController: NavController
) {
    var tabIndex = remember { mutableStateOf(0) }
    val tabs = listOf("News", "Coins")
    Column(modifier = Modifier.background(color = colorResource(id = R.color.grey_black))) {
        Scaffold(
            modifier = Modifier.background(colorResource(id = R.color.grey_black)),
            topBar = { NewsAppBar(greetingContent = { AppBarContent("Saved", R.drawable.saved_sc) }) },
            bottomBar = { BottomNavigationBar(navController = navController) },
            content = {
                it
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.grey_black))
                ) {
                    TabRow(
                        modifier = Modifier
                            .background(color = colorResource(id = R.color.purple_protest))
                            .height(60.dp),
                        selectedTabIndex = tabIndex.value,
                        backgroundColor = colorResource(id = R.color.grey_black),
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                modifier = Modifier
                                    .tabIndicatorOffset(tabPositions[tabIndex.value])
                                    .fillMaxWidth()
                                    .height(1.dp),
                                color = colorResource(id = R.color.purple_protest)
                            )
                        }
                    ) {
                        tabs.forEachIndexed { index, title ->
                            Tab(
                                selected = tabIndex.value == index,
                                onClick = { tabIndex.value = index }
                            ) {
                                Text(text = title, style = MaterialTheme.typography.titleMedium, color = Color.White)
                            }
                        }
                    }

                    when (tabs[tabIndex.value]) {
                        "News" -> SavedNewsScreen(navController = navController)
                        "Coins" -> CoinMarketPlaceScreen(navController = navController)
                    }
                }
            }
        )
    }
}