package com.betulkircil.cryptoinsight.presentation.view.metaverseNewsScreen


import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.animations.NewsColumnShimmerEffect
import com.betulkircil.cryptoinsight.presentation.view.gamingScreen.GamingViewModel
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsColumnContent
import kotlinx.coroutines.delay

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun GamingNewsScreen(
    navController: NavController,
    viewModel: GamingViewModel = hiltViewModel()
) {
    var isLoading = remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = true) {
        delay(2000)
        isLoading.value = false

    }
    val state = viewModel.state.value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .height(400.dp)
            .padding(horizontal = 20.dp)
    ) {
        items(state.newsList) { news ->
            NewsColumnShimmerEffect(
                isLoading = isLoading.value,
                contentAfterLoading = {
                    NewsColumnContent(item = news)
                }
            )
        }
    }
}