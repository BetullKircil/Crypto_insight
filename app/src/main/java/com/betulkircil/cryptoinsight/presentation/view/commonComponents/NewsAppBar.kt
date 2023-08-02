package com.betulkircil.cryptoinsight.presentation.view.commonComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@Composable
fun NewsAppBar(greetingContent: @Composable () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(color = colorResource(id = R.color.grey_black)), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp)) {
            greetingContent()
        }
        Text(text = "ehehehehe", color = Color.White, modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp))
    }
}