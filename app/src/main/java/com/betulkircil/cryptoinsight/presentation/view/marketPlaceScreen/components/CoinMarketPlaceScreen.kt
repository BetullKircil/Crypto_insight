package com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.CustomScrollableTabRow
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.screenEvents.CoinsEvent
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.viewModels.AllCoinsViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CoinMarketPlaceScreen(
    navController: NavController,
    allCoinsViewModel: AllCoinsViewModel = hiltViewModel()
) {
    val state = allCoinsViewModel.state.value
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        CustomScrollableTabRow(navController = navController)
    }
}