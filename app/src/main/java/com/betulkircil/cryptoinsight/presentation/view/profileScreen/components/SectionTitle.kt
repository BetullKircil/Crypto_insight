package com.betulkircil.cryptoinsight.presentation.view.profileScreen.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun SectionTitle(sectionTitle : String) {
    Text(text = sectionTitle, style = MaterialTheme.typography.titleLarge,color = Color.White)
}