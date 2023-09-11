package com.betulkircil.cryptoinsight.presentation.view.commonComponents

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil.compose.rememberImagePainter
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.domain.model.NewsModel
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.shareNews
import com.betulkircil.cryptoinsight.presentation.view.savedScreen.viewmodels.SavedCoinsViewModel
import com.betulkircil.cryptoinsight.presentation.view.savedScreen.viewmodels.SavedNewsViewModel

@Composable
fun NewsColumnContent(
    item : NewsModel,
    savedNewsViewModel: SavedNewsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    var currentPainter = remember { mutableStateOf(R.drawable.saved) }
    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 3.dp).padding(top = 10.dp), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = currentPainter.value), contentDescription = null, modifier = Modifier
                .clickable {
                    savedNewsViewModel.saveNews(item)
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
            Image(painter = painterResource(id = R.drawable.share), contentDescription = null, modifier = Modifier
                .clickable {
                    shareNews(item, context)
                }
                .size(18.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val url = item.url ?: ""
                    if (url.isNotEmpty()) {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    }
                }, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.width(270.dp)) {
                    Text(
                        text = item.title ?: "",
                        modifier = Modifier.padding(horizontal = 10.dp),
                        style = MaterialTheme.typography.titleSmall,
                        lineHeight = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = item.description?: "",
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
                    painter = rememberImagePainter(data = item.urlToImage),
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