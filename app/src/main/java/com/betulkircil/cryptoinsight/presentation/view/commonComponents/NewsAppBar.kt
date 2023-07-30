package com.betulkircil.cryptoinsight.presentation.view.commonComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NewsAppBar(greetingContent: @Composable () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .padding(top = 10.dp).padding(horizontal = 20.dp)
        .background(Color.Transparent), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        greetingContent()
        Text(text = "ehehehehe")
    }
}