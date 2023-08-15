package com.betulkircil.cryptoinsight.presentation.view.animations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun LazyStaggeredShimmerEffect(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if(isLoading) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(190.dp, 220.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .shimmerEffect()
            )
        }
    } else {
        contentAfterLoading()
    }
}