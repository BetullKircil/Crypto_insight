package com.betulkircil.cryptoinsight.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.betulkircil.cryptoinsight.presentation.ui.theme.CryptoInsightTheme
import com.betulkircil.cryptoinsight.presentation.view.CategoryScreen.CategoryScreen
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.CoinScreen
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.AllCoinsScreen
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.FavoriteCoinsScreen
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.NewsLazyStaggeredVerticalGrid
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.NewsRowScreen
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.HomeScreen
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginScreen
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.MarketPlaceAndNewsSearchScreen
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.ProfileScreen
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpMail.SignUpMailScreen
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpName.SignUpNameScreen
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.signUpPassword.SignUpPasswordScreen
import com.betulkircil.cryptoinsight.presentation.view.splashScreen.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoInsightTheme {
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


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route){
        composable(Screen.SplashScreen.route){  //Splasch screen cagirilackak
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
            SignUpMailScreen(navController = navController)
        }
        composable(Screen.SignUpNameScreen.route){
            SignUpNameScreen(navController = navController)
        }
        composable(Screen.SignUpPasswordScreen.route){
            SignUpPasswordScreen(navController = navController)
        }
        composable(Screen.AllCoinsScreen.route){
            AllCoinsScreen(navController = navController)
        }
        composable(Screen.FavoriteCoinsScreen.route){
            FavoriteCoinsScreen(navController = navController)
        }
        composable(Screen.NewsRowScreen.route){
            NewsRowScreen(navController = navController)
        }
        composable(Screen.NewsLazyStaggeredGrid.route){
            NewsLazyStaggeredVerticalGrid(navController = navController)
        }
        composable(Screen.MarketPlaceAndNewsSearchScreen.route){
            MarketPlaceAndNewsSearchScreen(navController = navController)
        }
        composable(Screen.CategoryScreen.route){
            CategoryScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
    }
}