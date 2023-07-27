package com.betulkircil.cryptoinsight.presentation

sealed class Screen(val route : String){
    object SplashScreen : Screen("splashScreen")
    object CoinScreen : Screen("coinScreen")
    object HomeScreen : Screen("homeScreen")
    object LoginScreen : Screen("loginScreen")
    object SignUpMailScreen : Screen("signUpMailScreen")
    object SignUpNameScreen : Screen("signUpNameScreen")
    object SignUpPasswordScreen : Screen("signUpPasswordScreen")
}
