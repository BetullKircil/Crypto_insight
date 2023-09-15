package com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize : Int,
    pagerState: PagerState,
    selectedPage : Int,
    selectedColor : Color = colorResource(id = R.color.purple_protest),
    unselectedColor : Color = Color.Gray
) {
   Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween) {
       repeat(pageSize){ page ->
           Spacer(modifier = Modifier.width(3.dp))
           Box(
               modifier = Modifier.size(18.dp, 3.dp).clip(CircleShape)
                   .background(color = if (page == pagerState.currentPage) selectedColor else unselectedColor)

           )
       }
   } 
}