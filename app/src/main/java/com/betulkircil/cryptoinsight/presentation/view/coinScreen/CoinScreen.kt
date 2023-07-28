package com.betulkircil.cryptoinsight.presentation.view.coinScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.GreetingText
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsAppBar

@Composable
fun CoinScreen(navController: NavController) {
    Column (modifier = Modifier.fillMaxSize()){
        NewsAppBar(content = { GreetingText(userName = "Betul Kircil")})
        //GreetingText()
    }
    
}