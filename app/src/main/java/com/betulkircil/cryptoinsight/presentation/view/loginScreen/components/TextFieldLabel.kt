package com.betulkircil.cryptoinsight.presentation.view.loginScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldLabel(text : String) {
    Row(modifier = Modifier.padding(horizontal = 40.dp).fillMaxWidth().padding(top = 15.dp), horizontalArrangement = Arrangement.Start) {
        Text(text = text, color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Light)
    }
}