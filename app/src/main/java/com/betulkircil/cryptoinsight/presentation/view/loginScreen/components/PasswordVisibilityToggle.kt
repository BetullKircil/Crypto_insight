package com.betulkircil.cryptoinsight.presentation.view.loginScreen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@Composable
fun PasswordVisibilityToggle(
    isVisible: Boolean,
    onToggle: (Boolean) -> Unit
) {
    val icon: Painter = if (isVisible) {
        painterResource(id = R.drawable.visibility)
    } else {
        painterResource(id = R.drawable.visibility_off)
    }

    IconButton(
        onClick = { onToggle(!isVisible) },
        modifier = Modifier.padding(4.dp)
    ) {
        Icon(icon, contentDescription = "Toggle password visibility")
    }
}