package com.betulkircil.cryptoinsight.presentation.view.commonComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.betulkircil.cryptoinsight.R

@Composable
fun BackgroundImage() {
    val backgroundImage: Painter = painterResource(R.drawable.background_image)
    Image(
        painter = backgroundImage,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}