package com.betulkircil.cryptoinsight.presentation.view.entryScreen.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.betulkircil.cryptoinsight.R

@Composable
fun LogoText() {
    Image(painter = painterResource(id = R.drawable.logo_text), contentDescription =null )

}