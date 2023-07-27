package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen

@Composable
fun LogoGroupSignUp(navController : NavController) {
    Column(modifier = Modifier
        .fillMaxHeight()
        .padding(vertical = 25.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier) {
            Image(painter = painterResource(id = R.drawable.sign_up_line), contentDescription = null)
            Row(modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally), horizontalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = R.drawable.google), contentDescription = null, modifier = Modifier.padding(horizontal = 10.dp))
                Image(painter = painterResource(id = R.drawable.twitter), contentDescription = null, modifier = Modifier.padding(horizontal = 10.dp))
            }
        }
        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
            SignUpLinkText(firstText = "Already a member?", linkText = "Sign In", navController = navController, route = Screen.LoginScreen.route)
            ButtonWithIcon(route = Screen.SignUpNameScreen.route, navController = navController, buttonText = "Next", width = 500)
        }

    }
}
