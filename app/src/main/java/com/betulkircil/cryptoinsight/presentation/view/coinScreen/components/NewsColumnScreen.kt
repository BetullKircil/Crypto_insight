package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import android.content.Context
import android.os.Build
import android.webkit.WebView
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.animations.NewsColumnShimmerEffect
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.viewModels.NewsViewModel
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsColumnContent
import com.betulkircil.cryptoinsight.presentation.view.savedScreen.SavedNewsViewModel
import kotlinx.coroutines.delay

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NewsColumnScreen(
    navController: NavController,
    newsViewModel: NewsViewModel = hiltViewModel(),
    savedNewsViewModel: SavedNewsViewModel = hiltViewModel()
) {
    var isLoading = remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = true) {
        delay(2000)
        isLoading.value = false

    }
    val context = LocalContext.current
    val state = newsViewModel.state.value
    var visibleNewsCount = remember { mutableStateOf(5) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .height(400.dp)
            .padding(horizontal = 20.dp)
    ) {
        items(state.newsList.reversed().take(visibleNewsCount.value)) { news ->
            NewsColumnShimmerEffect(
                isLoading = isLoading.value,
                contentAfterLoading = {
                    NewsColumnContent(item = news)
                }
            )
        }
    }
    Row(modifier = Modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier
            .fillMaxSize()
            .height(170.dp), contentAlignment = Alignment.Center){
            Button(onClick = {
                visibleNewsCount.value += 5
            },
                modifier = Modifier
                    .fillMaxWidth(0.4f),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(
                    id = R.color.button_color
                )),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "See More")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebViewComposable(context : Context, url: String, onBackClick: () -> Unit) {
    val context = LocalContext.current

    Column {
        TopAppBar(
            title = { Text(text = "WebView") },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )

        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    loadUrl(url)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}
