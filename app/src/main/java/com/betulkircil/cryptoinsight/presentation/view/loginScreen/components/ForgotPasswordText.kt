package com.betulkircil.cryptoinsight.presentation.view.loginScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@Composable
fun ForgotPasswordText() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { /*todo*/ }
        .padding(horizontal = 20.dp, vertical = 5.dp), horizontalArrangement = Arrangement.End) {
        Text(modifier = Modifier.clickable { print("Tiklandi") }, text = stringResource(id = R.string.forgotPassword), color = colorResource(id = R.color.purple_protest), style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium, textAlign = TextAlign.End)
    }
}