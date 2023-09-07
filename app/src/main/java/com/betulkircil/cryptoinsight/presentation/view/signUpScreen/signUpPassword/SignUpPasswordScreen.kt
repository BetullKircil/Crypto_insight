package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.signUpPassword

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.AppBarSection
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BackgroundImage
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpViewModel
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.BackNextButtonGroup
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.SignUpText
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.signUpPassword.components.SignUpPasswordScreenContent
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.signUpPassword.components.SignUpPasswordText
import kotlinx.coroutines.launch

@Composable
fun SignUpPasswordScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
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
                SignUpPasswordScreenContent()
                Column(modifier = Modifier
                    .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                    SignUpPasswordText()
                    Box(modifier = Modifier.padding(vertical = 25.dp)) {
                        BackNextButtonGroup(navController = navController, backRoute = Screen.SignUpNameScreen.route, nextRoute = Screen.CoinScreen.route)
                    }
                }
            }
        }
    }
}