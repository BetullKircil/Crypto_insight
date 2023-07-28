package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun GreetingText(userName : String) {
    val greeting = getGreeting()
    Row(modifier = Modifier) {
        Text(text = greeting)
        Text(text = userName)
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
