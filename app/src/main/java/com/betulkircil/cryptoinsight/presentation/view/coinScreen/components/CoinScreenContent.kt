package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CoinScreenContent(navController: NavController) {
    Column(modifier = Modifier, verticalArrangement = Arrangement.SpaceEvenly) {
        Box(modifier = Modifier.height(350.dp)) {
            Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                PageTitle(text = "Coins")
                CustomScrollableTabRow(navController = navController)
            }
        }
        Box(modifier = Modifier.padding(top = 10.dp)){
            PageTitle(text = "Important News")
        }
        Box(modifier = Modifier.height(300.dp)){
            NewsRowScreen(navController = navController)
        }
        Box(modifier = Modifier.padding(vertical = 10.dp)) {
            PageTitle(text = "News ->")
        }
        NewsColumnScreen(navController = navController)
   }
}

