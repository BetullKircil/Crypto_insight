package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen

@Composable
fun BackNextButtonGroup(navController : NavController, backRoute: String, nextRoute: String, modifier: Modifier = Modifier) {
    Row(modifier = Modifier
        .fillMaxWidth().padding(start = 25.dp)) {
        BackButton(route = backRoute, navController = navController, buttonText = "Back", textColor = colorResource(id = R.color.purple_protest), backgroundColor = Color.Transparent)
        ButtonWithIcon(route = nextRoute, navController = navController, buttonText = "Next", width = 200)
    }
}