package com.betulkircil.cryptoinsight.presentation.view.profileScreen


import android.app.AlertDialog
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
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
) {
    val openDialogCustom = remember { mutableStateOf(false) }

    val isLoggedIn = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val openAlertDialog = remember { mutableStateOf(false) }

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
                            navController.navigate(Screen.AllCoinsScreen.route)
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


fun Context.sendMail(to: String, subject: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "vnd.android.cursor.item/email" // or "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Log.d("Error",e.message.toString())
    } catch (t: Throwable) {
        Log.d("Error",t.message.toString())
    }
}

@Composable
fun CustomDialogUI(modifier: Modifier = Modifier, openDialogCustom: MutableState<Boolean>, loginViewModel:LoginViewModel, navController: NavController){
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(350.dp),
        contentAlignment = Alignment.Center) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(horizontal = 20.dp),
            elevation = 8.dp
        ) {
            Column(
                modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pp_logout),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(
                        color = colorResource(id = R.color.purple_protest)
                    ),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .height(70.dp)
                        .fillMaxWidth(),

                    )
                Column(modifier = Modifier.padding(16.dp)) {
                    androidx.compose.material3.Text(
                        text = "Warning",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .fillMaxWidth(),
                        style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    androidx.compose.material3.Text(
                        text = "Are you sure you would like to log out?",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.body2
                    )
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .background(color = colorResource(id = R.color.morado_purple)),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    androidx.compose.material3.TextButton(onClick = {
                        openDialogCustom.value = false
                    }) {
                        androidx.compose.material3.Text(
                            "Yes",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.grey_black_bg),
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp).clickable {
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
                        )
                    }
                    androidx.compose.material3.TextButton(onClick = {
                        openDialogCustom.value = false
                    }) {
                        androidx.compose.material3.Text(
                            "Cansel",
                            fontWeight = FontWeight.ExtraBold,
                            color = colorResource(id = R.color.grey_black_bg),
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp).clickable {
                                Toast
                                    .makeText(context, "Log out is cancelled!", Toast.LENGTH_SHORT)
                                    .show()
                                openDialogCustom.value = false
                            }
                        )
                    }
                }
            }
        }
    }
}
