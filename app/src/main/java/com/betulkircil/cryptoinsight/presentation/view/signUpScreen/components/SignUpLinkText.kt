package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R

@Composable
fun SignUpLinkText(firstText : String, linkText : String, navController: NavController, route : String) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 25.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = firstText, color = Color.White, fontSize = 13.sp,fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.width(5.dp))
            Text(modifier = Modifier.clickable { navController.navigate(route) }, text = linkText, color = colorResource(id = R.color.purple_protest), style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium, fontSize = 13.sp)
        }
    }
}