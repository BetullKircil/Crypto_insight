package com.betulkircil.cryptoinsight.presentation.view.profileScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle

@Composable
fun SavedNews() {
    Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        Row(modifier = Modifier) {
            Image(painter = painterResource(id = R.drawable.pp_saved), contentDescription = null)
            Column(modifier = Modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                PageTitle(text = "Saved News")
                ProfileLabelTexts(text = "Your previously saved news")
            }
        }
        Image(painter = painterResource(id = R.drawable.next_arrow), contentDescription = null)
    }
}