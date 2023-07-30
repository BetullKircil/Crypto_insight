package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.Screen

val navController = NavController
sealed class NewsCategoryTabItems(var route : String){
    object Favorites : NewsCategoryTabItems(route = Screen.HomeScreen.route)
    object All : NewsCategoryTabItems(route = Screen.LoginScreen.route)
    object Gaming : NewsCategoryTabItems(route = Screen.HomeScreen.route)
    object Defi : NewsCategoryTabItems(route = Screen.HomeScreen.route)

}
