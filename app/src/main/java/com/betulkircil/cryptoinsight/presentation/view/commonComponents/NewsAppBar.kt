package com.betulkircil.cryptoinsight.presentation.view.commonComponents

import android.util.Log
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.data.remote.dto.Coin
import com.betulkircil.cryptoinsight.domain.model.Coins
import com.betulkircil.cryptoinsight.presentation.view.animations.ShimmerLoopEffect
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.AppBarCardItem
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.viewModels.AllCoinsViewModel
import kotlinx.coroutines.delay
import java.lang.Thread.sleep
import javax.inject.Inject

@Composable
fun NewsAppBar(
    greetingContent: @Composable () -> Unit,
    allCoinsViewModel: AllCoinsViewModel = hiltViewModel(),
) {
    var isLoading = remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = true) {
        delay(1000)
        isLoading.value = false

    }
    val state = allCoinsViewModel.state.value
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(color = colorResource(id = R.color.grey_black)), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp)) {
            greetingContent()
        }
        Box(modifier = Modifier
            .height(30.dp)
            .width(120.dp)){
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.coins) { coin ->
                    ShimmerLoopEffect(
                        isLoading = isLoading.value,
                        contentAfterLoading = {
                            AppBarCardItem(coin = coin)
                        }
                    )
                }
            }
        }
    }
}
