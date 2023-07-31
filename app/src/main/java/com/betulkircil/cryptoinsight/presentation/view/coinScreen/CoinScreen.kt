package com.betulkircil.cryptoinsight.presentation.view.coinScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.CustomScrollableTabRow
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.GreetingText
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsAppBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.HomeScreen
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginScreen
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpName.SignUpNameScreen

@Composable
fun CoinScreen(navController: NavController) {
            Column (modifier = Modifier.fillMaxSize().background(color = Color.Blue)){
                NewsAppBar(greetingContent = { GreetingText(userName = "Betul Kircil")})
                        PageTitle(text = "Coins")
                        Column {
                            var selectedTabIndex by remember { mutableIntStateOf(0) }
                            val tabs = listOf("Favorites", "All", "Metaverse", "Gaming", "Defi", "Innovation", "NFT")
                            CustomScrollableTabRow(
                                tabs = tabs,
                                selectedTabIndex = selectedTabIndex,
                            ) { tabIndex ->
                                selectedTabIndex = tabIndex
                            }
                            /*Box(modifier = Modifier.fillMaxHeight(0.4f)) {
                                when (tabs[selectedTabIndex]) {
                                    "Favorites" -> LoginScreen(navController = navController)
                                    "All" -> HomeScreen(navController)
                                    "Metaverse" -> SignUpNameScreen(navController)
                                    "Gaming" -> LoginScreen(navController = navController)
                                    "Defi" -> HomeScreen(navController = navController)
                                    "Innovation" -> LoginScreen(navController = navController)
                                    "NFT" -> HomeScreen(navController = navController)
                                }
                            }*/
                            LazyColumn(modifier = Modifier.fillMaxHeight(0.4f)) {
                                items(1) { index ->
                                    Box(modifier = Modifier.fillMaxHeight(0.4f)) {
                                        when (tabs[selectedTabIndex]) {
                                            "Favorites" -> LoginScreen(navController = navController)
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
                }
        }