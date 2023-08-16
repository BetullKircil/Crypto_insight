package com.betulkircil.cryptoinsight.presentation.view.commonComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.grey_black),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        BottomNavigationItem(
            icon = {
                IconButton(onClick = {
                    navController.navigate(Screen.LoginScreen.route)}) {
                    Image(painter = painterResource(id = R.drawable.home_not_clicked), contentDescription = null, modifier = Modifier.size(20.dp))
                }
            },
            selected = true,
            onClick = { /*todo*/ },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = {
                IconButton(onClick = { navController.navigate(Screen.MarketPlaceAndNewsSearchScreen.route)}) {
                    Image(painter = painterResource(R.drawable.news_not_clicked), contentDescription = null, modifier = Modifier.size(20.dp))
                }            },
            selected = false,
            onClick = { navController.navigate(Screen.MarketPlaceAndNewsSearchScreen.route) },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = {
                IconButton(onClick = { navController.navigate(Screen.CategoryScreen.route) }) {
                    Image(painter = painterResource(R.drawable.search_not_clicked), contentDescription = null, modifier = Modifier.size(20.dp))
                }
            },
            selected = true,
            onClick = { /*TODO*/ },
        )
        BottomNavigationItem(
            icon = {
                IconButton(onClick = {  }) {
                    Image(painter = painterResource(R.drawable.saved_not_clicked), contentDescription = null, modifier = Modifier.size(20.dp))
                }            },
            selected = true,
            onClick = { /*TODO*/ },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = {
                IconButton(onClick = {  }) {
                    Image(painter = painterResource(R.drawable.profile_not_clicekd), contentDescription = null, modifier = Modifier.size(20.dp))
                }            },
            selected = true,
            onClick = { /*TODO*/ },
            alwaysShowLabel = false
        )
    }
}
