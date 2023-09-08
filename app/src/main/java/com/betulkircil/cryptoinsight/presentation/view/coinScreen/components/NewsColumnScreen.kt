package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresExtension
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.animations.NewsColumnShimmerEffect
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.viewModels.NewsViewModel
import com.betulkircil.cryptoinsight.presentation.view.savedScreen.viewmodels.SavedNewsViewModel
import kotlinx.coroutines.delay
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

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
    var currentPainter = remember { mutableStateOf(R.drawable.saved) }

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
                    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .padding(top = 5.dp), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = currentPainter.value), contentDescription = null, modifier = Modifier
                                .clickable {
                                    savedNewsViewModel.saveFavoriteNews(news)
                                    Toast
                                        .makeText(
                                            context,
                                            "News saved succesfully!",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                                .size(20.dp))
                            Spacer(modifier = Modifier.size(5.dp))
                            Image(painter = painterResource(id = R.drawable.share), contentDescription = null, modifier = Modifier.clickable {
                                //will be  shared
                            }.size(18.dp))
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .clickable { /*todo*/ },
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    val url = news.url ?: ""
                                    if (url.isNotEmpty()) {
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                        context.startActivity(intent)
                                    }
                                }, horizontalArrangement = Arrangement.SpaceBetween) {
                                Column(modifier = Modifier.width(270.dp).padding(top = 10.dp), verticalArrangement = Arrangement.Center) {
                                    val publishedAtDateTime = LocalDateTime.parse(news.publishedAt, DateTimeFormatter.ISO_DATE_TIME)
                                    val systemInstant = remember { Instant.now() }
                                    val duration = Duration.between(publishedAtDateTime.atZone(
                                        ZoneId.systemDefault()).toInstant(), systemInstant)
                                    var timeDifference = formatDuration(duration)
                                    Row(modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 10.dp), horizontalArrangement = Arrangement.Start) {
                                        Text(text = "$timeDifference ago",  fontSize = 10.sp, modifier = Modifier, color = Color.White)
                                    }
                                    Text(
                                        text = news.title ?: "",
                                        modifier = Modifier.padding(horizontal = 10.dp),
                                        style = MaterialTheme.typography.titleSmall,
                                        lineHeight = 18.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = news.description?: "",
                                        color = Color.White,
                                        modifier = Modifier.padding(horizontal = 10.dp),
                                        fontWeight = FontWeight.Light,
                                        style = MaterialTheme.typography.bodySmall,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis,
                                        fontSize = 10.sp
                                    )
                                }
                                Image(
                                    painter = rememberImagePainter(data = news.urlToImage),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(100.dp)
                                        .clip(RoundedCornerShape(20.dp))
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(0.8.dp)
                                .background(color = colorResource(id = R.color.purple_protest))
                        )
                    }
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


