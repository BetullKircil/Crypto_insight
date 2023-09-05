package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

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
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.domain.model.Coins

@Composable
fun CoinCardItem(coin: Coins) {
    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = rememberImagePainter(data = coin.image),
                contentDescription = coin.name,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .size(20.dp, 20.dp)
                    .clip(RoundedCornerShape(20))
            )
            Text(
                text = coin.symbol.uppercase(),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    text = coin.name.trim(),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                    fontWeight = FontWeight.Light
                )
            }
            Spacer(
                modifier = Modifier
                    .width(40.dp)
                    .background(color = Color.White)
            )
            Text(
                text = "$ " + coin.currentPrice.toString().substring(0, 3),
                color = Color.White
            )
            Text(
                text = if (coin.marketCapChange24Percentage > 0) "+" + coin.marketCapChange24Percentage.toString()
                    .substring(
                        0,
                        4
                    ) + "%" else coin.marketCapChange24Percentage.toString()
                    .substring(0, 5) + "%",
                color = if (coin.marketCapChange24Percentage < 0) Color.Red else Color.Green,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(color = colorResource(id = R.color.purple_protest))
        ) {

        }
    }
}