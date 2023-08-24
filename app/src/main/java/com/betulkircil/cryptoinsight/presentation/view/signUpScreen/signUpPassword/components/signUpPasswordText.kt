package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.signUpPassword.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@Composable
fun SignUpPasswordText() {
    Text(text = stringResource(id = R.string.signUpPasswordText), color = Color.White ,style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp), fontWeight = FontWeight.Light)
}