package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.betulkircil.cryptoinsight.domain.model.Coins

@Composable
fun AppBarCardItem(coin: Coins) {
    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(data = coin.image),
                contentDescription = coin.name,
                modifier = Modifier
                    .size(20.dp, 20.dp)
                    .clip(RoundedCornerShape(20))
            )
            Text(
                text = coin.symbol.uppercase(),
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 5.dp)
            )
            Text(
                text = "$ " + coin.currentPrice.toString().substring(0, 4),
                color = if (coin.marketCapChange24Percentage < 0) Color.Red else Color.Green
            )
        }
    }
}