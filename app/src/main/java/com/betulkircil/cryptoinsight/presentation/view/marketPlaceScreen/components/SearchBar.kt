package com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@Composable
fun SearchBar(
    hint : String = "",
    onSearch : (String) -> Unit = {}
    ) {
    var searchText = remember {
        mutableStateOf("")
    }
    var isHintDisplayed = remember {
        mutableStateOf(hint != "")
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .padding(20.dp), contentAlignment = Alignment.Center,) {
        TextField(
            value = searchText.value,
            onValueChange = {
                searchText.value = it
            },
            maxLines = 1,
            singleLine = true,
            textStyle = androidx.compose.material3.MaterialTheme.typography.bodyMedium.copy(
                color = Color.White
            ),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                onSearch(searchText.value)
            }),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    isHintDisplayed.value = it.isFocused != true && searchText.value.isEmpty()
                }
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(22.dp),
                    color = colorResource(id = R.color.purple_protest)
                )
        )

        if(isHintDisplayed.value){
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
                    Image(painter = painterResource(id = R.drawable.search_not_clicked), contentDescription = null, modifier = Modifier
                        .size(30.dp)
                        .padding(horizontal = 7.dp))
                    Text(text = hint, color = Color.LightGray, modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp), fontWeight = FontWeight.Light)
                }
        }
    }
}