package com.betulkircil.cryptoinsight.presentation.view.entryScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@Composable
fun EntryIconTextBox() {
    Box(modifier = Modifier.padding(20.dp)) {
        Image(painter = painterResource(id = R.drawable.entry_icon), contentDescription = null, )
        Image(painter = painterResource(id = R.drawable.stay_ahead_text), contentDescription = null, modifier = Modifier.padding(
            top = 300.dp
        ))
    }
}