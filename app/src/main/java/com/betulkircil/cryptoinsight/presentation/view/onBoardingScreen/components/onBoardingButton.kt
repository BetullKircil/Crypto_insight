package com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingButton(
    text : String,
    onClick: () -> Unit
) {
    val pagerState = androidx.compose.foundation.pager.rememberPagerState(initialPage = 2, pageCount = {pages.size})
    val scope = rememberCoroutineScope()
    Button(
        onClick = {
            onClick()
        },
        shape = RoundedCornerShape(40),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 25.dp)
            .height(50.dp),
        border = BorderStroke(
            2.dp,
            colorResource(id = R.color.purple_protest)
        ),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = colorResource(
                id = R.color.purple_protest
            )
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 5.dp)
            )
        }
    }
}