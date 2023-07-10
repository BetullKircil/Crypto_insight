package com.betulkircil.cryptoinsight.presentation.view.entryScreen

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.Screen.EntryScreen.route
import com.betulkircil.cryptoinsight.presentation.view.entryScreen.components.ButtonWithBorder
import java.nio.ByteOrder

@Composable
fun EntryScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
        Image(painter = painterResource(id = R.drawable.logo_text), contentDescription =null )
        Box(modifier = Modifier.padding(20.dp)) {
            Image(painter = painterResource(id = R.drawable.entry_icon), contentDescription = null, )
            Image(painter = painterResource(id = R.drawable.stay_ahead_text), contentDescription = null, modifier = Modifier.padding(
                top = 300.dp
            ))
        }
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally){
            ButtonWithBorder(route = Screen.SplashScreen.route, navController = navController, buttonText = "Login", textColor = colorResource(id = R.color.purple_protest), backgroundColor = Color.Transparent
            )
            ButtonWithBorder(route = Screen.HomeScreen.route, navController = navController, buttonText = "Create an account", )
        }
    }
}
