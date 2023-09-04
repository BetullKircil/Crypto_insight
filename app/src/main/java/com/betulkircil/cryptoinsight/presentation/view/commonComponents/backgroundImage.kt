package com.betulkircil.cryptoinsight.presentation.view.commonComponents

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
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
        modifier = Modifier
            .fillMaxSize()
        ,
        contentScale = ContentScale.Crop
    )
}