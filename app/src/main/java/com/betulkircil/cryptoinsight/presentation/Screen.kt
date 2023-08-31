package com.betulkircil.cryptoinsight.presentation

sealed class Screen(val route : String){
    object SplashScreen : Screen("splashScreen")
    object CoinScreen : Screen("coinScreen")
    object HomeScreen : Screen("homeScreen")
    object LoginScreen : Screen("loginScreen")
    object SignUpMailScreen : Screen("signUpMailScreen")
    object SignUpNameScreen : Screen("signUpNameScreen")
    object SignUpPasswordScreen : Screen("signUpPasswordScreen")
    object AllCoinsScreen : Screen("allCoinsScreen")
    object FavoriteCoinsScreen : Screen("favoriteCoinsScreen")
    object NftsScreen : Screen("nftsScreen")
    object NewsRowScreen : Screen("newsRowScreen")
    object NewsLazyStaggeredGrid : Screen("newsLazyStaggeredGrid")
    object MarketPlaceAndNewsSearchScreen : Screen("marketPlaceScreen")
    object CategoryScreen : Screen("categoryScreen")
    object ProfileScreen : Screen("profileScreen")
}
