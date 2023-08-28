package com.betulkircil.cryptoinsight.presentation.view.profileScreen


import android.app.AlertDialog
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BottomNavigationBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginViewModel
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ImagePickerComp
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ProfileInfo
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ProfileOptions
import org.w3c.dom.Text

@Composable
fun ProfileScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    profileViewModel: profileViewModel = hiltViewModel()
) {
    val userProfile = profileViewModel.userProfile.collectAsState().value
    val isLoggedIn = remember {
        mutableStateOf(false)
    }

    fun isLoggedInCheck() : Boolean{
        return isLoggedIn.value
    }

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        profileViewModel.fetchUserProfile()
    }

    if (userProfile != null) {
        Log.d("hata", "hata")
    }
    else{
        Log.d("cekildi", "${userProfile}")
    }

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
                Column(modifier = Modifier.padding(vertical = 25.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(modifier = Modifier.size(90.dp)) {
                        ImagePickerComp()
                    }
                   /* userProfile?.let {
                        ProfileInfo(
                            name = it.name ?: "",
                            email = loginViewModel?.currentUser?.displayName?:"",
                            no = it.phoneNumber ?: ""
                        )
                    }*/
                   ProfileInfo(name = loginViewModel?.currentUser?.displayName?:"", email = "", no = "")
                    if(loginViewModel.currentUser != null){
                        isLoggedIn.value = true
                    }
                }
                Column(modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 20.dp)
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
                            val alertDialogBuilder = AlertDialog.Builder(context)
                            alertDialogBuilder.setTitle("Warning")
                            alertDialogBuilder.setMessage("Are you sure you would like to log out?")
                            alertDialogBuilder.setPositiveButton("Yes") { dialog, which ->
                                loginViewModel.logout()
                                Toast
                                    .makeText(
                                        context,
                                        "Logged out successfully!",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                                navController.navigate("loginScreen") {
                                    popUpTo("profileScreen") { inclusive = true }
                                }
                            }
                            alertDialogBuilder.setNegativeButton("Cancel") { dialog, which ->
                                Toast
                                    .makeText(context, "Log out is cancelled!", Toast.LENGTH_SHORT)
                                    .show()
                            }
                            alertDialogBuilder
                                .create()
                                .show()
                        }) {
                        ProfileOptions(sectionTitle = "Log Out", sectionText = "Log out from your account", pngRes = R.drawable.pp_logout, onClick = {

                        })
                    }
                }
            }
        }
    )
}