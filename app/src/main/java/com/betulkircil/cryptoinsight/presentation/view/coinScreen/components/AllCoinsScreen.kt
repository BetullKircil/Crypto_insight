package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.animations.CoinsShimmerListItem
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.viewModels.AllCoinsViewModel
import kotlinx.coroutines.delay

@Composable
fun AllCoinsScreen(
    allCoinsViewModel: AllCoinsViewModel = hiltViewModel()
) {
    var isLoading = remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = true) {
        delay(1000)
        isLoading.value = false

    }
    val state = allCoinsViewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.grey_black))
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            CoinSectionTitles()
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.coins) { coin ->
                    CoinsShimmerListItem(
                        isLoading = isLoading.value,
                        contentAfterLoading = {
                            CoinCardItem(coin = coin)
                        }
                    )
                }
            }
        }
    }
}
