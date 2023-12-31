package com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.components.LogoText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page,
    navController: NavController,
    pagerState: PagerState
    ) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.padding(horizontal = 25.dp)) {
            Column(modifier = Modifier.padding(top = 20.dp)) {
                LogoText()
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 20.dp), horizontalArrangement = Arrangement.End) {
                    Text(
                        text = "Skip",
                        modifier = Modifier.clickable { navController.navigate(Screen.HomeScreen.route) },
                        style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                        color = colorResource(
                            id = R.color.purple_protest
                        )
                    )
                }
            }
            Image(
                painter = painterResource(id = page.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = 0.6f)
                    .padding(vertical = 10.dp)
            )
            Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                PageIndicator(pageSize = pages.size, selectedPage = pagerState.currentPage, pagerState = pagerState)
                Text(text = page.title, style = androidx.compose.material3.MaterialTheme.typography.titleLarge, modifier = Modifier.padding(top = 20.dp, start = 15.dp), fontWeight = FontWeight.Bold, color = Color.White, textAlign = TextAlign.Center,)
                Text(text = page.description, style = androidx.compose.material3.MaterialTheme.typography.bodySmall, modifier = Modifier, color = Color.White, textAlign = TextAlign.Center)
            }
        }
    }
}