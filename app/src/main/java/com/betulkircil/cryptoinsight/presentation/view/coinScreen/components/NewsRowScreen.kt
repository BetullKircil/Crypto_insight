package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.animations.NewsRowShimmerEffect
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.viewModels.NewsViewModel
import kotlinx.coroutines.delay
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SuspiciousIndentation")
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NewsRowScreen(
    navController: NavController,
    viewModel: NewsViewModel = hiltViewModel()
) {
    var isLoading = remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = true) {
        delay(1400)
        isLoading.value = false

    }
    val context = LocalContext.current
    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){
        Column(modifier = Modifier
            .height(500.dp)) {
            LazyRow(modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.grey_black))){
                items(state.newsList){ news ->
                    val paddingModifier = Modifier.padding(horizontal = 10.dp)
                    NewsRowShimmerEffect(
                        isLoading = isLoading.value,
                        contentAfterLoading = {
                            Card(modifier = Modifier
                                .padding(20.dp)
                                .background(color = colorResource(id = R.color.grey_black_bg))
                                .width(300.dp),
                                onClick = {
                                    val url = news.url
                                    if (url.isNotEmpty()) {
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                        context.startActivity(intent)
                                    }
                                }
                            ) {
                                Column(modifier = Modifier
                                    .fillMaxHeight()
                                    .background(color = colorResource(id = R.color.grey_black_bg)), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                                    Box(modifier = Modifier
                                        .height(150.dp)){
                                        Row(modifier = Modifier, horizontalArrangement = Arrangement.Center) {
                                            Image(
                                                painter = rememberImagePainter(data = news.urlToImage),
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .size(250.dp)
                                                    .clip(RoundedCornerShape(20.dp))
                                            )
                                        }
                                    }
                                    val hour = news.publishedAt.substring(11, 16)
                                    val publishedAtDateTime = LocalDateTime.parse(news.publishedAt, DateTimeFormatter.ISO_DATE_TIME)
                                    val systemInstant = remember { Instant.now() }
                                    val duration = Duration.between(publishedAtDateTime.atZone(ZoneId.systemDefault()).toInstant(), systemInstant)
                                    var timeDifference = formatDuration(duration)
                                    Row(modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 10.dp), horizontalArrangement = Arrangement.Start) {
                                        Text(text = "$timeDifference ago",  fontSize = 10.sp, modifier = Modifier, color = Color.White)
                                    }
                                    Text(text = news.title,
                                        modifier = paddingModifier, style = MaterialTheme.typography.titleMedium, lineHeight = 18.sp, color = Color.White ,fontWeight = FontWeight.Bold, maxLines = 2, overflow = TextOverflow.Ellipsis)
                                    Text(text = news.description,
                                        color = Color.White,
                                        modifier = paddingModifier, fontWeight = FontWeight.Light , style = MaterialTheme.typography.bodyMedium, maxLines = 2, overflow = TextOverflow.Ellipsis, fontSize = 10.sp)
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
fun formatDuration(duration: Duration): String {
    val hours = duration.toHours()
    val minutes = duration.toMinutes() % 60
    return "${hours}h ${minutes}m"
}
