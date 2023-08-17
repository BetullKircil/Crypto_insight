package com.betulkircil.cryptoinsight.presentation.view.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BottomNavigationBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsAppBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.AppBarContent
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ImagePickerComp
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ProfileInfo

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.grey_black)),
        bottomBar = { BottomNavigationBar(navController = navController) },
        content = {
            it
            Column(modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.grey_black))) {
                PageTitle(text = "Profile")
                ImagePickerComp()
                Box(modifier = Modifier)
                ProfileInfo(name = "Betul", email = "a", no = "23334")
            }
        }
    )
}