package com.betulkircil.cryptoinsight.presentation.view.profileScreen

import android.graphics.Insets.add
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BottomNavigationBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsAppBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.AppBarContent
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ImagePickerComp
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ProfileInfo
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ProfileOptions
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.components.ProfileProcessComp

@Composable
fun ProfileScreen(navController: NavController) {
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
                Column(modifier = Modifier.padding(vertical = 5.dp)) {
                    Box(modifier = Modifier.size(90.dp)) {
                        ImagePickerComp()
                    }
                    ProfileInfo(name = "Betul", email = "a", no = "23334")
                }
                Column(modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 40.dp)
                    .padding(bottom = 60.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    ProfileOptions(sectionTitle = "Settings", sectionText = "Account, App Setings etc.", pngRes = R.drawable.pp_settings)
                    ProfileOptions(sectionTitle = "Saved News", sectionText = "Your previously saved news", pngRes = R.drawable.pp_saved)
                    ProfileOptions(sectionTitle = "News Sources", sectionText = "Preffered News Sources", pngRes = R.drawable.pp_source)
                    ProfileOptions(sectionTitle = "Feedback", sectionText = "Give us feedback to make your app better", pngRes = R.drawable.pp_feedback)
                    ProfileOptions(sectionTitle = "Privacy Policy", sectionText = "Prşvacy policy and terms of use", pngRes = R.drawable.pp_privacy_policy)
                    ProfileOptions(sectionTitle = "Log Out", sectionText = "Log out from your account", pngRes = R.drawable.pp_logout)
                }
            }
        }
    )
}

