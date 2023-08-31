package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.animations.CoinsShimmerListItem
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.viewModels.AllCoinsViewModel
import kotlinx.coroutines.delay

@Composable
fun FavoriteCoinsScreen(
    navController: NavController,
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
    val minPrice = 1.0
    val maxPrice = 500.0
    val maxChangePercentage = 2.0

    val filteredCoins = state.coins.filter { coin ->
        coin.currentPrice >= minPrice && coin.currentPrice <= maxPrice &&
                coin.marketCapChange24Percentage <= maxChangePercentage
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.grey_black))
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            CoinSectionTitles()
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(filteredCoins) { coin ->
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