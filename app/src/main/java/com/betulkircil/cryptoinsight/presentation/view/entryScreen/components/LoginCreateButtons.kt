package com.betulkircil.cryptoinsight.presentation.view.entryScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R

@Composable
fun ButtonWithBorder(route : String, navController: NavController, borderColor: Int = R.color.purple_protest, buttonText: String, textColor: Color = Color.White, backgroundColor : Color = colorResource(
    id = R.color.purple_protest
)
) {
    Button(
        onClick = {
            navController.navigate(route)
        },
        shape = RoundedCornerShape(40),
        modifier = Modifier
            .fillMaxWidth()
            .padding(23.dp, 9.dp)
            .height(50.dp),
        border = BorderStroke(2.dp, colorResource(id = borderColor)),
        colors = ButtonDefaults.elevatedButtonColors(containerColor = backgroundColor)
    ) {
        Text(text = buttonText, color = textColor, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
    }
}