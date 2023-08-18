package com.betulkircil.cryptoinsight.presentation.view.splashScreen.components

import androidx.compose.animation.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.betulkircil.cryptoinsight.R

@Composable
fun SplashScreenLogo() {
    Box(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
    contentAlignment = Alignment.Center,
) {
    Image(painter = painterResource(id = R.drawable.logo), contentDescription = null)

}
}