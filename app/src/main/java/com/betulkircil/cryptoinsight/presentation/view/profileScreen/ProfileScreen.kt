package com.betulkircil.cryptoinsight.presentation.view.profileScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BottomNavigationBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginViewModel
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.CustomDialogUI
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ImagePickerComp
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ProfileInfo
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ProfileOptions
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.sendMail

@Composable
fun ProfileScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel(),
) {
    val openDialogCustom = remember { mutableStateOf(false) }

    val isLoggedIn = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current

Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.grey_black)),
        bottomBar = { BottomNavigationBar(navController = navController) },
        content = { it
            val scrollState = rememberScrollState()
            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(colorResource(id = R.color.grey_black)), horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalArrangement = Arrangement.Start) {
                    PageTitle(text = "Profile")
                }
                Column(modifier = Modifier.padding(vertical = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(modifier = Modifier.size(90.dp)) {
                        ImagePickerComp()
                    }
                   ProfileInfo(name = loginViewModel?.currentUser?.displayName?:"", email = "", no = "")
                    if(loginViewModel.currentUser != null){
                        isLoggedIn.value = true
                    }
                }
                Column(modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 60.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable {

                        }) {
                        ProfileOptions(
                            sectionTitle = "Settings",
                            sectionText = "Account, App Setings etc.",
                            pngRes = R.drawable.pp_settings,
                            onClick = {})
                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navController.navigate(Screen.SavedScreen.route)
                        }) {
                        ProfileOptions(
                            sectionTitle = "Saved News/Coins",
                            sectionText = "Your previously saved news",
                            pngRes = R.drawable.pp_saved,
                            onClick = {})
                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navController.navigate(Screen.CategoryScreen.route)
                        }) {
                        ProfileOptions(
                            sectionTitle = "News Sources",
                            sectionText = "Preffered News Sources",
                            pngRes = R.drawable.pp_source,
                            onClick = {})
                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            context.sendMail(to = "example@gmail.com", subject = "Some subject")
                        }) {
                        ProfileOptions(
                            sectionTitle = "Feedback",
                            sectionText = "Give us feedback to make your app better",
                            pngRes = R.drawable.pp_feedback,
                            onClick = { /*todo*/})
                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable {

                        }) {
                        ProfileOptions(
                            sectionTitle = "Privacy Policy",
                            sectionText = "Privacy policy and terms of use",
                            pngRes = R.drawable.pp_privacy_policy,
                            onClick = {})
                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            openDialogCustom.value = true
                        }) {
                        ProfileOptions(sectionTitle = "Log Out", sectionText = "Log out from your account", pngRes = R.drawable.pp_logout, onClick = {

                        })
                    }
                }
            }
        }
    )
    if (openDialogCustom.value) {
        CustomDialogUI(openDialogCustom = openDialogCustom, navController = navController, loginViewModel = loginViewModel)
    }
}




