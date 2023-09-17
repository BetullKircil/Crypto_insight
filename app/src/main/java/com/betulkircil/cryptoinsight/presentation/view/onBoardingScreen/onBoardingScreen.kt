package com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen.components.OnBoardingButton
import com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen.components.OnBoardingPage
import com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen.components.PageIndicator
import com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen.components.pages
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent) -> Unit,
    navController : NavController
) {
    val pagerState = androidx.compose.foundation.pager.rememberPagerState(initialPage = 0, pageCount = {pages.size})
    val scope = rememberCoroutineScope()
    Scaffold(
        content = {it
            Column(modifier = Modifier
                .fillMaxHeight()
                .background(color = colorResource(id = R.color.grey_black)), verticalArrangement = Arrangement.SpaceAround) {
                androidx.compose.foundation.pager.HorizontalPager(state = pagerState) {index ->
                    OnBoardingPage(page = pages[index], navController = navController, pagerState = pagerState)
                }
            }},
        bottomBar = {
            OnBoardingButton("Next", onClick = {
                if (pagerState.currentPage < pages.size - 1) {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                } else {
                    navController.navigate(Screen.HomeScreen.route)
                    event(OnBoardingEvent.SaveAppEntry)
                }
            })
        }
    )
}