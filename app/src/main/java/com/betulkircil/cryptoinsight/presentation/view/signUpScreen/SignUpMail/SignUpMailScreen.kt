package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpMail

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.AppBarSection
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.BackgroundImage
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.TextFieldLabel
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.LogoGroupSignUp
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.SignUpText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpMailScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Surface(modifier = Modifier.fillMaxSize()) {
            BackgroundImage()
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppBarSection(navController, "homeScreen" ,"signUpMailScreen")
                SignUpText()
                Column(modifier = Modifier.padding(vertical = 20.dp).padding(top = 25.dp)
                    , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                ) {
                    var email = remember { mutableStateOf("") }
                    var phoneNumber = remember { mutableStateOf("") }
                    var isClicked = remember { mutableStateOf(false) }
                    var passwordVisibility = remember { mutableStateOf(false) }
                    TextFieldLabel(text = "Email")
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .clickable {
                                isClicked.value = !isClicked.value
                            }
                            .border(
                                width = 2.5.dp,
                                color = colorResource(id = R.color.purple_protest),
                                shape = RoundedCornerShape(22.dp)
                            ),
                        value = email.value,
                        leadingIcon = { Row{
                            Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon", modifier = Modifier.padding(start = 15.dp), tint = Color.Gray)
                            Image(painter = painterResource(id = R.drawable.line), contentDescription = "line", modifier = Modifier.padding(horizontal = 7.dp
                            ))
                        } },
                        onValueChange = {
                            email.value = it
                        },
                        shape = RoundedCornerShape(22.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = colorResource(id = R.color.purple_protest),
                            containerColor = Color.White
                        ),keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.None,
                            autoCorrect = true,
                            imeAction = ImeAction.Next
                        ),
                        placeholder = { Text(text = "example@gmail.com", style = MaterialTheme.typography.bodyMedium, color = Color.Gray) }
                    )
                    TextFieldLabel(text = "Telephone Number")
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .border(
                                width = 2.5.dp,
                                color = colorResource(id = R.color.purple_protest),
                                shape = RoundedCornerShape(22.dp)
                            ),
                        value = phoneNumber.value,
                        leadingIcon = {
                            Row(modifier = Modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                Icon(painter = painterResource(id = R.drawable.country_code), contentDescription = null, modifier = Modifier.padding(horizontal = 10.dp))
                                Image(painter = painterResource(id = R.drawable.line), contentDescription = "line", modifier = Modifier
                                )
                            }
                        },
                        onValueChange = {
                            phoneNumber.value = it
                        },
                        shape = RoundedCornerShape(22.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = colorResource(id = R.color.purple_protest),
                            containerColor = Color.White
                        ),keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.None,
                            autoCorrect = true,
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        placeholder = {
                            Text(text = "555 555 55 55", style = MaterialTheme.typography.bodyMedium, color = Color.Gray, modifier = Modifier.padding(horizontal = 5.dp).padding(top = 2.dp)) }
                    )
                }
                LogoGroupSignUp(navController = navController)
            }
        }
    }
}