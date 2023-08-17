package com.betulkircil.cryptoinsight.presentation.view.profileScreen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProfileLabelTexts(text : String) {
    Text(text = text, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Light, color = Color.White, modifier = Modifier.padding(vertical = 3.dp))
}