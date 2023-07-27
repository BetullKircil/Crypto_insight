package com.betulkircil.cryptoinsight.presentation.view.commonComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.components.LogoText

@Composable
fun AppBarSection(navController: NavController, route : String, backStackRoute : String? = null) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp).padding(top = 10.dp)
        .background(Color.Transparent), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = Icons.Default.KeyboardArrowLeft, tint = Color.White, contentDescription = "back", modifier = Modifier
            .size(50.dp)
            .clickable {
                navController.navigate(route){
                    if (backStackRoute != null) {
                        popUpTo(backStackRoute){inclusive = true}
                    }
                }

            }.padding(start = 15.dp))
        LogoText()
    }
}