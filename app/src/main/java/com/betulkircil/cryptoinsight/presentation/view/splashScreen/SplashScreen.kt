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
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
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
       if(viewModel.isLoggedIn().value){
            navController.navigate(Screen.CoinScreen.route)
           Log.d("Coine", "Coine gidecek")
        }
        else{
            navController.navigate(Screen.HomeScreen.route)
           Log.d("Home", "Home gidecek")
        }
        Log.d("snsf", "${viewModel.isLoggedIn().value}")
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