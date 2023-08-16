package com.betulkircil.cryptoinsight.presentation.view.CategoryScreen

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.CategoryScreen.components.LazyVerticalGridDemo
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BottomNavigationBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsAppBar
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.AppBarContent

@Composable
fun CategoryScreen(navController : NavController) {
    Scaffold(
        topBar = { NewsAppBar(greetingContent = { AppBarContent() }) },
        bottomBar = { BottomNavigationBar(navController = navController) },
        content = {
           it
            LazyVerticalGridDemo()
        }
    )
}