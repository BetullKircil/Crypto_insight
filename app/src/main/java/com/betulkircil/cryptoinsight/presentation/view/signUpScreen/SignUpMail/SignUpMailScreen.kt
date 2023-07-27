package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpMail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.AppBarSection
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BackgroundImage
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpMail.components.SignUpMailScreenContent
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.LogoGroupSignUp
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.SignUpText

@Composable
fun SignUpMailScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Surface(modifier = Modifier.fillMaxSize()) {
            BackgroundImage()
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppBarSection(navController, "homeScreen" ,"signUpMailScreen")
                SignUpText()
                SignUpMailScreenContent()
                LogoGroupSignUp(navController = navController)
            }
        }
    }
}