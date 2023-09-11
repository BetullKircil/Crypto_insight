package com.betulkircil.cryptoinsight.presentation.view.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.components.ButtonWithBorder
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.components.EntryIconTextBox
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.components.LogoText

@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
        .background(Color.Black), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
        LogoText()
        EntryIconTextBox()
        Spacer(modifier = Modifier.height(30.dp))
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally){
            ButtonWithBorder(
                route = Screen.LoginScreen.route, navController = navController, buttonText = "Login", textColor = colorResource(id = R.color.purple_protest), backgroundColor = Color.Transparent
            )
            ButtonWithBorder(route = Screen.SignUpMailScreen.route, navController = navController, buttonText = "Create an account", )
        }
    }
}

