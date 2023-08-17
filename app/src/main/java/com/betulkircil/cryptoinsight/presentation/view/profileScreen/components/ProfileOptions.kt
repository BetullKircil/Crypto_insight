package com.betulkircil.cryptoinsight.presentation.view.profileScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@Composable
fun ProfileOptions(sectionTitle: String, sectionText: String? = null, pngRes: Int) {
    val painter: Painter = painterResource(id = pngRes)
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Row(modifier = Modifier.width(210.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Image(painter = painter, contentDescription = null, modifier = Modifier.size(50.dp))
            Column(modifier = Modifier.padding(horizontal = 10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {
                SectionTitle(sectionTitle = sectionTitle)
                ProfileLabelTexts(text = sectionText?:"")
            }
        }
        Image(painter = painterResource(id = R.drawable.next_arrow), contentDescription = null, modifier = Modifier.size(25.dp))
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .background(color = colorResource(id = R.color.purple_protest))
    )
}