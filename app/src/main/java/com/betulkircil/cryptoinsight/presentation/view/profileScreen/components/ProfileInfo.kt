package com.betulkircil.cryptoinsight.presentation.view.profileScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle

@Composable
fun ProfileInfo(name : String, email : String, no : String) {
    Column(modifier = Modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        PageTitle(text = name)
        ProfileLabelTexts(text = email)
        ProfileLabelTexts(text = no)
    }
}