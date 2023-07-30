package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun GreetingText(userName : String) {
    val greeting = getGreeting()
    Row(modifier = Modifier, horizontalArrangement = Arrangement.Center) {
        Text(text = greeting, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Light)
        AppBarText(userName = userName)
    }
}

fun getGreeting(): String {
    val cal = Calendar.getInstance()
    val sdf = SimpleDateFormat("HH", Locale.getDefault())
    val hour = sdf.format(cal.time).toInt()

    return when (hour) {
        in 5..11 -> "Good Morning"
        in 12..16 -> "Good Afternoon"
        else -> "Good Evening"
    }
}


