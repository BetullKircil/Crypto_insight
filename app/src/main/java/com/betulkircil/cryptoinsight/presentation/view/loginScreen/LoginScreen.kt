package com.betulkircil.cryptoinsight.presentation.view.loginScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BackgroundImage
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.Login
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.LoginScreenContent
import com.betulkircil.cryptoinsight.utils.ShowMessageUtil.Companion.showMessage


@Composable
fun LoginScreen(
    navController: NavController,
    ) {

    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Surface(modifier = Modifier.fillMaxSize()) {
            BackgroundImage()
            LoginScreenContent(navController = navController)
        }
    }
    Login(showErrorMessage = { errorMessage ->
        showMessage(context, errorMessage)
    })
}

