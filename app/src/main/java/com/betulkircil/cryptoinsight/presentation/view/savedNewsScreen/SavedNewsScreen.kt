package com.betulkircil.cryptoinsight.presentation.view.savedNewsScreen

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.betulkircil.cryptoinsight.domain.model.NewsModel
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BottomNavigationBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsAppBar
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.AppBarContent

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun SavedNewsScreen(
    navController : NavController,
    viewModel: SavedNewsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val savedNews: List<NewsModel> by viewModel.savedNewsFlow.collectAsState(emptyList())
    Column(modifier = Modifier.background(color = colorResource(id = R.color.grey_black))) {
        Scaffold(
            modifier = Modifier.background(colorResource(id = R.color.grey_black)),
            topBar = { NewsAppBar(greetingContent = { AppBarContent("Saved", R.drawable.saved_sc) }) },
            bottomBar = { BottomNavigationBar(navController = navController) },
            content = {
                it
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.grey_black))
                        .verticalScroll(rememberScrollState())) {
                        savedNews.forEach { news ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
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
                                    Column(modifier = Modifier.width(270.dp)) {
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
                        }
                }
            }
        )
    }
}