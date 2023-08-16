package com.betulkircil.cryptoinsight.presentation.view.CategoryScreen.components


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@Composable
fun LazyVerticalGridDemo(searchQuery : String) {
    val context = LocalContext.current
    val list = listOf<String>("Coins", "Blockchain", "NFTs", "WEB3", "Metaverse", "DAO", "Finance")

    val filteredList = list.filter { it.contains(searchQuery, ignoreCase = true) }
    val imageResIds = listOf(
        R.drawable.coins,
        R.drawable.blockchain,
        R.drawable.nft,
        R.drawable.web3,
        R.drawable.metaverse,
        R.drawable.dao,
        R.drawable.finance
    )
    val urls = listOf(
        "https://economictimes.indiatimes.com/markets/cryptocurrency",
        "https://economictimes.indiatimes.com/topic/blockchain-technology",
        "https://timesofindia.indiatimes.com/topic/nft/news",
        "https://economictimes.indiatimes.com/topic/web3",
        "https://economictimes.indiatimes.com/topic/metaverse-tech",
        "https://economictimes.indiatimes.com/topic/decentralized-autonomous-organization-dao",
        "https://timesofindia.indiatimes.com/business"
    )

    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = Modifier.background(color = colorResource(id = R.color.grey_black)),
        contentPadding = PaddingValues(
            horizontal = 10.dp,
            vertical = 20.dp
        ),
        content = {
            items(filteredList.size) { index ->
                val url = urls[index]
                Card(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.grey_black))
                        .clickable {
                            if (url.isNotEmpty()) {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                context.startActivity(intent)
                            }
                        },
                ) {
                    Column(
                        modifier = Modifier.background(color = colorResource(id = R.color.grey_black)),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = imageResIds[index]),
                            contentDescription = null
                        )
                        Text(
                            text = filteredList[index],
                            fontWeight = FontWeight.Light,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White,
                            modifier = Modifier.padding(vertical = 7.dp)
                        )
                    }

                }
            }
        }
    )
}