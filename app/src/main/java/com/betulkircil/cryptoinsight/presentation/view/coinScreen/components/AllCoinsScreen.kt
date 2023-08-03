package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.AllCoinsViewModel

@Composable
fun AllCoinsScreen(
    navController: NavController,
    allCoinsViewModel: AllCoinsViewModel = hiltViewModel()
) {
    val state = allCoinsViewModel.state.value
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.purple_200))){
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(state.coins){coin->
                    Text(text = coin.name)
                }
            }
        }
    }
}