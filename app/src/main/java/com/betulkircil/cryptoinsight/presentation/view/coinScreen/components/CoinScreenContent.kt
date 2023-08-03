package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle

@Composable
fun CoinScreenContent(navController: NavController) {
    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
        CustomScrollableTabRow(navController = navController)
        PageTitle(text = "Important")
    }
}

