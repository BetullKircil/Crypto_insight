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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.utils.Constants.BLOCKCHAIN_CATEGORY_URL
import com.betulkircil.cryptoinsight.utils.Constants.COINS_CATEGORY_URL
import com.betulkircil.cryptoinsight.utils.Constants.DAO_CATEGORY_URL
import com.betulkircil.cryptoinsight.utils.Constants.FINANCE_CATEGORY_URL
import com.betulkircil.cryptoinsight.utils.Constants.METAVERSE_CATEGORY_URL
import com.betulkircil.cryptoinsight.utils.Constants.NFT_CATEGORY_URL
import com.betulkircil.cryptoinsight.utils.Constants.WEB3_CATEGORY_URL

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
        COINS_CATEGORY_URL,
        BLOCKCHAIN_CATEGORY_URL,
        NFT_CATEGORY_URL,
        WEB3_CATEGORY_URL,
        METAVERSE_CATEGORY_URL,
        DAO_CATEGORY_URL,
        FINANCE_CATEGORY_URL,


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