package com.betulkircil.cryptoinsight.presentation

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.domain.useCase.appEntryUseCase.AppEntryUseCases
import com.betulkircil.cryptoinsight.presentation.ui.theme.CryptoInsightTheme
import com.betulkircil.cryptoinsight.presentation.view.CategoryScreen.CategoryScreen
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.CoinScreen
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.AllCoinsScreen
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.FavoriteCoinsScreen
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.NewsLazyStaggeredVerticalGrid
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.components.NewsRowScreen
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.HomeScreen
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginScreen
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginViewModel
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.MarketPlaceAndNewsSearchScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseNewsScreen.DefiNewsScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseNewsScreen.GamingNewsScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseNewsScreen.InnovationNewsScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseNewsScreen.MetaverseNewsScreen
import com.betulkircil.cryptoinsight.presentation.view.metaverseNewsScreen.NftNewsScreen
import com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen.OnBoardinfScreenViewmodel
import com.betulkircil.cryptoinsight.presentation.view.onBoardingScreen.OnBoardingScreen
import com.betulkircil.cryptoinsight.presentation.view.profileScreen.ProfileScreen
import com.betulkircil.cryptoinsight.presentation.view.savedScreen.SavedScreen
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpMail.SignUpMailScreen
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpName.SignUpNameScreen
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.signUpPassword.SignUpPasswordScreen
import com.betulkircil.cryptoinsight.presentation.view.splashScreen.SplashScreen
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var useCases: AppEntryUseCases
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            useCases.readAppEntry().collect{
                Log.d("Test",it.toString())
            }
        }
        setContent {
            SetStatusBarColor()
            CryptoInsightTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationComponent()
                }
            }
        }
    }
}


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NavigationComponent(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route){
        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.CoinScreen.route){
            CoinScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(Screen.SignUpMailScreen.route){
            SignUpMailScreen(navController = navController)
        }
        composable(Screen.SignUpNameScreen.route){
            SignUpNameScreen(navController = navController)
        }
        composable(Screen.SignUpPasswordScreen.route){
            SignUpPasswordScreen(navController = navController)
        }
        composable(Screen.AllCoinsScreen.route){
            AllCoinsScreen()
        }
        composable(Screen.FavoriteCoinsScreen.route){
            FavoriteCoinsScreen(navController = navController)
        }
        composable(Screen.NewsRowScreen.route){
            NewsRowScreen(navController = navController)
        }
        composable(Screen.NewsLazyStaggeredGrid.route){
            NewsLazyStaggeredVerticalGrid(navController = navController)
        }
        composable(Screen.MarketPlaceAndNewsSearchScreen.route){
            MarketPlaceAndNewsSearchScreen(navController = navController)
        }
        composable(Screen.CategoryScreen.route){
            CategoryScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
        composable(Screen.MetaverseNewsScreen.route){
            MetaverseNewsScreen(navController = navController)
        }
        composable(Screen.GamingNewsScreen.route){
            GamingNewsScreen(navController = navController)
        }
        composable(Screen.DefiNewsScreen.route){
            DefiNewsScreen(navController = navController)
        }
        composable(Screen.DefiNewsScreen.route){
            NftNewsScreen(navController = navController)
        }
        composable(Screen.DefiNewsScreen.route){
            InnovationNewsScreen(navController = navController)
        }
        composable(Screen.SavedScreen.route){
            SavedScreen(navController = navController)
        }
        composable(Screen.OnBoardingScreen.route){
            val viewmodel : OnBoardinfScreenViewmodel = hiltViewModel()
            OnBoardingScreen(navController = navController,
            event = {viewmodel::onEvent})
        }
    }
}

@Composable
fun SetStatusBarColor() {
    val systemUiController : SystemUiController = rememberSystemUiController()
    val purpleProtestColor = colorResource(id = R.color.grey_black)
    LaunchedEffect(key1 = true) {
        systemUiController.setStatusBarColor(purpleProtestColor)
    }
}