package com.betulkircil.cryptoinsight.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.betulkircil.cryptoinsight.presentation.ui.theme.CryptoInsightTheme
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.CoinScreen
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.HomeScreen
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginScreen
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpNameScreen
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpScreen
import com.betulkircil.cryptoinsight.presentation.view.splashScreen.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoInsightTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationComponent()
                }
            }
        }
    }
}


@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route){
        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.CoinScreen.route){
            CoinScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(Screen.SignUpMailScreen.route){
            SignUpScreen(navController = navController)
        }
        composable(Screen.SignUpNameScreen.route){
            SignUpNameScreen(navController = navController)
        }
    }
}