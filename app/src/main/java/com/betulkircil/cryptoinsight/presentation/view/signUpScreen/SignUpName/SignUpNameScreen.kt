package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpName

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.AppBarSection
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.BackgroundImage
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.TextFieldLabel
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.BackNextButtonGroup
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.SignUpText
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.TextFieldName
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpNameScreen(navController : NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(), verticalArrangement = Arrangement.Center
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            BackgroundImage()
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppBarSection(navController, "signUpMailScreen")
                SignUpText()
                Column(
                    modifier = Modifier
                        .padding(top = 50.dp, bottom = 25.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                        var pickedDate = remember {
                            mutableStateOf(LocalDate.now())
                        }
                        var formattedDate = remember {
                            derivedStateOf {
                                DateTimeFormatter.ofPattern("MMM dd yyyy").format(pickedDate.value)
                            }
                        }
                        val dateTimeDialogState = rememberMaterialDialogState()
                        TextFieldLabel(text = "Full Name")
                        TextFieldName()
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 15.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                            Column(modifier = Modifier.width(170.dp)) {
                                Text(text = "Date of Birth", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Light, modifier = Modifier.padding(horizontal = 20.dp))
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(
                                            width = 2.5.dp,
                                            color = colorResource(id = R.color.purple_protest),
                                            shape = RoundedCornerShape(22.dp)
                                        ),
                                    value = pickedDate.value.toString(),
                                    leadingIcon = {
                                        Row {
                                            Icon(
                                                painter = painterResource(id = R.drawable.calender),
                                                contentDescription = "calender",
                                                modifier = Modifier
                                                    .padding(start = 15.dp)
                                                    .clickable { dateTimeDialogState.show() },
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
                                    onValueChange = {
                                    },
                                    shape = RoundedCornerShape(22.dp),
                                    colors = TextFieldDefaults.textFieldColors(
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        cursorColor = colorResource(id = R.color.purple_protest),
                                        containerColor = Color.White
                                    ), keyboardOptions = KeyboardOptions(
                                        capitalization = KeyboardCapitalization.None,
                                        autoCorrect = true,
                                        imeAction = ImeAction.Next
                                    ),
                                    readOnly = true,
                                )
                            }
                            Column(modifier = Modifier.width(170.dp)) {
                                Text(text = "Gender", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Light, modifier = Modifier.padding(horizontal = 20.dp))
                                GenderDropDownMenu(modifier = Modifier)
                            }
                        }
                        MaterialDialog(dialogState = dateTimeDialogState,
                            buttons = {
                                positiveButton("OK")
                                negativeButton("Cansel")
                            }
                        ) {
                            datepicker(
                                initialDate = LocalDate.now(),
                                title = "Pick a Date"
                            ) {
                                pickedDate.value = it
                            }
                        }
                    }
                    BackNextButtonGroup(navController = navController, backRoute = Screen.SignUpMailScreen.route, nextRoute = Screen.SignUpPasswordScreen.route)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderDropDownMenu(modifier: Modifier) {
    var isExpanded = remember {
        mutableStateOf(false)
    }
    val options = listOf("Male", "Female", "Other")
    var selectedOption = remember {
        mutableStateOf(options[0])
    }

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