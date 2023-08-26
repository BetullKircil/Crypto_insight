package com.betulkircil.cryptoinsight.presentation.view.splashScreen

import android.content.Context
import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
   // var isLoggedIn = isLoggedIn(context)
   // Log.d("isLoggedIn", "${isLoggedIn}")
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(0.5f).getInterpolation(it)
                }
            )
        )
        delay(1000L)
       /* if(isLoggedIn){
            navController.navigate(Screen.CoinScreen.route)
        }
        else{
            navController.navigate(Screen.HomeScreen.route)
        }
        saveLoginStatus(context, isLoggedIn)*/
        navController.navigate(Screen.HomeScreen.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center,
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null, modifier = Modifier.scale(scale.value))

    }
}

fun saveLoginStatus(context: Context, isLoggedIn: Boolean) {
    val sharedPreferences = context.getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean("isLoggedIn", isLoggedIn)
    editor.apply()
}

fun isLoggedIn(context: Context): Boolean {
    val sharedPreferences = context.getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean("isLoggedIn", false)
}