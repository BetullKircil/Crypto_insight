package com.betulkircil.cryptoinsight.presentation.view.loginScreen.components

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
import com.betulkircil.cryptoinsight.R

@Composable
fun CreateAccountText() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            letterSpacing = 1.3.sp, modifier = Modifier.padding(12.dp)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Not a member?", color = Color.White)
            Spacer(modifier = Modifier.width(5.dp))
            Text(modifier = Modifier.clickable { print("Tiklandi") }, text = "Create an Account Now", color = colorResource(id = R.color.purple_protest), style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
        }
    }
}