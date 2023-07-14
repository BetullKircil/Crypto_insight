package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R

@Composable
fun ButtonWithIcon(
    route: String, navController: NavController, borderColor: Int = R.color.purple_protest, buttonText: String, textColor: Color = Color.White, backgroundColor: Color = colorResource(
        id = R.color.purple_protest
    ), width : Int
) {
    Box(modifier = Modifier.width(width = width.dp)){
        Button(
            onClick = {
                navController.navigate(route)
            },
            shape = RoundedCornerShape(40),
            modifier = Modifier
                .fillMaxWidth()
                .padding(23.dp, 0.dp)
                .height(50.dp),
            border = BorderStroke(2.dp, colorResource(id = borderColor)),
            colors = ButtonDefaults.elevatedButtonColors(containerColor = backgroundColor)
        ) {
            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = buttonText, color = textColor, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                Image(painter = painterResource(id = R.drawable.arrow_right), contentDescription = null, modifier = Modifier.padding(horizontal = 5.dp))
            }
        }
    }
}