package com.betulkircil.cryptoinsight.presentation.view.coinScreen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.GreetingText
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsAppBar
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.HomeScreen
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginScreen
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpName.SignUpNameScreen

@Composable
fun CoinScreen(navController: NavController) {
    Column (modifier = Modifier.fillMaxSize()){
        NewsAppBar(greetingContent = { GreetingText(userName = "Betul Kircil")})
        Column {
            var selectedTabIndex by remember { mutableIntStateOf(0) }
            val tabs = listOf("Favorites", "All", "Metaverse", "Gaming", "Defi", "Innovation", "NFT")
                CustomScrollableTabRow(
                    tabs = tabs,
                    selectedTabIndex = selectedTabIndex,
                ) { tabIndex ->
                    selectedTabIndex = tabIndex
                }
            Box(modifier = Modifier.height(300.dp)) {
                when (tabs[selectedTabIndex]) {
                    "Favorites" -> LoginScreen(navController)
                    "All" -> HomeScreen(navController)
                    "Metaverse" -> SignUpNameScreen(navController)
                    "Gaming" -> LoginScreen(navController = navController)
                    "Defi" -> HomeScreen(navController = navController)
                    "Innovation" -> LoginScreen(navController = navController)
                    "NFT" -> HomeScreen(navController = navController)
                }
            }
        }
    }
}

@Composable
fun CustomScrollableTabRow(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit
) {
    val density = LocalDensity.current
    val tabWidths = remember {
        val tabWidthStateList = mutableStateListOf<Dp>()
        repeat(tabs.size) {
            tabWidthStateList.add(0.dp)
        }
        tabWidthStateList
    }
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = Color.Black,
        backgroundColor = Color.Transparent,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                color = colorResource(id = R.color.purple_protest),
                modifier = Modifier.customTabIndicatorOffset(
                    currentTabPosition = tabPositions[selectedTabIndex],
                    tabWidth = tabWidths[selectedTabIndex]
                )
            )
        }
    ) {
        tabs.forEachIndexed { tabIndex, tab ->
            Tab(
                selected = selectedTabIndex == tabIndex,
                onClick = { onTabClick(tabIndex) },
                text = {
                    Text(
                        text = tab,
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.Light,
                        onTextLayout = { textLayoutResult ->
                            tabWidths[tabIndex] =
                                with(density) { textLayoutResult.size.width.toDp() }
                        }
                    )
                }
            )
        }
    }
}

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = ""
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = tabWidth,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    val indicatorOffset by animateDpAsState(
        targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}