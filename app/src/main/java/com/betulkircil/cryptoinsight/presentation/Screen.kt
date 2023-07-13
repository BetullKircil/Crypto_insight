package com.betulkircil.cryptoinsight.presentation

sealed class Screen(val route : String){
    object SplashScreen : Screen("splashScreen")
    object HomeScreen : Screen("homeScreen")
    object EntryScreen : Screen("entryScreen")
    object LoginScreen : Screen("loginScreen")
    object SignUpScreen : Screen("signUpScreen")
}
