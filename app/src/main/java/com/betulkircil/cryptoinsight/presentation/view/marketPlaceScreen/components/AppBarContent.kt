package com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@Composable
fun AppBarContent(appBarText :String, pngRes: Int) {
    val painter: Painter = painterResource(id = pngRes)
    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Text(text = appBarText, style = MaterialTheme.typography.bodySmall, color = Color.White, fontWeight = FontWeight.Light)
        Image(painter = painter, contentDescription = null, modifier = Modifier.size(15.dp))
    }
}