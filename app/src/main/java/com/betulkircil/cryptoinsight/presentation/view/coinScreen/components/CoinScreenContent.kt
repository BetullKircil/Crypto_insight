package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CoinScreenContent(navController: NavController) {
    Column(modifier = Modifier, verticalArrangement = Arrangement.SpaceEvenly) {
        Box(modifier = Modifier.height(350.dp)) {
            CustomScrollableTabRow(navController = navController)
        }
        PageTitle(text = "Important")
        Box(modifier = Modifier.height(300.dp)){
            NewsRowScreen(navController = navController)
        }
    }
}

