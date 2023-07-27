package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpName.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.betulkircil.cryptoinsight.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderDropDownMenu(modifier: Modifier) {
    var isExpanded = remember {
        mutableStateOf(false)
    }
    val options = listOf("Male", "Female", "Other")

    ExposedDropdownMenuBox(expanded = isExpanded.value, onExpandedChange = {
        isExpanded.value = !isExpanded.value
    }) {
        var gender = remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.5.dp,
                    color = colorResource(id = R.color.purple_protest),
                    shape = RoundedCornerShape(22.dp)
                )
                .menuAnchor(),
            value = gender.value,
            leadingIcon = {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.calender),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 15.dp)
                            .clickable { },
                        tint = Color.Gray
                    )
                    Image(
                        painter = painterResource(id = R.drawable.line),
                        contentDescription = "line",
                        modifier = Modifier.padding(
                            horizontal = 7.dp
                        )
                    )
                }
            },
            placeholder = {
                Text(text = "Female")
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded.value)
            },
            onValueChange = {},
            shape = RoundedCornerShape(22.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = colorResource(id = R.color.purple_protest),
                containerColor = Color.White
            ), keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                imeAction = ImeAction.Next,
            ),
            readOnly = true,
        )
        ExposedDropdownMenu(expanded = isExpanded.value, onDismissRequest = { isExpanded.value = false }) {
            DropdownMenuItem(text = { Text(text = options[0]) }, onClick = { gender.value = options[0]
                isExpanded.value = false
            })
            DropdownMenuItem(text = { Text(text = options[1]) }, onClick = { gender.value = options[1]
                isExpanded.value = false
            })
            DropdownMenuItem(text = { Text(text = options[2]) }, onClick = { gender.value = options[2]
                isExpanded.value = false
            })
        }
    }
}