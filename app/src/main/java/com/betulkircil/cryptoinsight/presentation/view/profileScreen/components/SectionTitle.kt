package com.betulkircil.cryptoinsight.presentation.view.profileScreen.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SectionTitle(sectionTitle : String) {
    Text(text = sectionTitle, fontSize = 17.sp,color = Color.White)
}