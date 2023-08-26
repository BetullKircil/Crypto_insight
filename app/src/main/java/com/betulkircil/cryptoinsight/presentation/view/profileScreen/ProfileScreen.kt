package com.betulkircil.cryptoinsight.presentation.view.profileScreen


import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BottomNavigationBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginViewModel
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ImagePickerComp
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ProfileInfo
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ProfileOptions
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    signUpViewModel: SignUpViewModel = hiltViewModel()
) {
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
                Column(modifier = Modifier.padding(vertical = 5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(modifier = Modifier.size(90.dp)) {
                        ImagePickerComp()
                    }
                    ProfileInfo(name = loginViewModel?.currentUser?.displayName?: "", email = loginViewModel?.currentUser?.displayName?:"", no = "05435980000")
                }
                Column(modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 40.dp)
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

                        }) {
                        ProfileOptions(
                            sectionTitle = "Saved News",
                            sectionText = "Your previously saved news",
                            pngRes = R.drawable.pp_saved,
                            onClick = {})
                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable {

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

                        }) {
                        ProfileOptions(
                            sectionTitle = "Feedback",
                            sectionText = "Give us feedback to make your app better",
                            pngRes = R.drawable.pp_feedback,
                            onClick = {})
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
                            loginViewModel.logout()
                            Toast.makeText(context, "Logged out successfully!", Toast.LENGTH_SHORT).show()
                            navController.navigate("loginScreen") {
                                popUpTo("profileScreen") { inclusive = true }
                            }
                        }) {
                        ProfileOptions(sectionTitle = "Log Out", sectionText = "Log out from your account", pngRes = R.drawable.pp_logout, onClick = {

                        })
                    }
                }
            }
        }
    )
}