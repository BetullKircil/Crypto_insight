package com.betulkircil.cryptoinsight.presentation.view.homeScreen.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@Composable
fun EntryIconTextBox() {
    Box(modifier = Modifier.padding(20.dp)) {
        val animatableScale = remember { Animatable(1f) }
        val targetScale = remember { mutableStateOf(1.2f) }
        val animationDuration = 2500

        LaunchedEffect(targetScale.value) {
            while (true) {
                animatableScale.animateTo(
                    targetScale.value,
                    animationSpec = tween(durationMillis = animationDuration)
                )
                animatableScale.animateTo(
                    1f,
                    animationSpec = tween(durationMillis = animationDuration)
                )
            }
        }

        Image(painter = painterResource(id = R.drawable.entry_icon),
            contentDescription = null,
            modifier = Modifier.graphicsLayer(
            scaleX = animatableScale.value,
            scaleY = animatableScale.value
        ))
        Image(painter = painterResource(id = R.drawable.stay_ahead_text), contentDescription = null, modifier = Modifier.padding(
            top = 300.dp
        ))
    }
}