package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@Composable
fun AppBarText(userName: String) {
    Row(modifier = Modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Text(text = " " + userName + " ", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
        Image(painter = painterResource(id = R.drawable.sun), contentDescription = null,modifier = Modifier.size(15.dp))
    }
}