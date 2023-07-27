package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.signUpPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.AppBarSection
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BackgroundImage
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PasswordVisibilityToggle
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.TextFieldLabel
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.BackNextButtonGroup
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.SignUpText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpPasswordScreen(navController: NavController) {
    var password = remember {
        mutableStateOf("")
    }
    var passwordAgain = remember {
        mutableStateOf("")
    }
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
                Column(modifier = Modifier
                    .padding(vertical = 20.dp).padding(top = 25.dp)
                    , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                ) {
                    var email = remember { mutableStateOf("") }
                    var phoneNumber = remember { mutableStateOf("") }
                    var isClicked = remember { mutableStateOf(false) }
                    var isClickedAgain = remember {
                        mutableStateOf(false)
                    }
                    var passwordVisibility = remember { mutableStateOf(false) }
                    var passwordVisibilityAgain = remember {
                        mutableStateOf(false)
                    }
                    TextFieldLabel(text = "Password")
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
                        value = password.value,
                        visualTransformation = if (passwordVisibility.value){
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        leadingIcon = { Row{
                            Icon(painter = painterResource(id = R.drawable.off)
                                , contentDescription = "password", modifier = Modifier.padding(start = 15.dp)
                            )
                            Image(painter = painterResource(id = R.drawable.line), contentDescription = "line", modifier = Modifier.padding(horizontal = 7.dp
                            ))
                        } },
                        trailingIcon = { PasswordVisibilityToggle(isVisible = passwordVisibility.value, onToggle = {passwordVisibility.value = it}) },
                        onValueChange = {
                            password.value = it
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
                    )
                    TextFieldLabel(text = "Password (Again)")
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .clickable {
                                isClickedAgain.value = !isClickedAgain.value
                            }
                            .border(
                                width = 2.5.dp,
                                color = colorResource(id = R.color.purple_protest),
                                shape = RoundedCornerShape(22.dp)
                            ),
                        value = passwordAgain.value,
                        visualTransformation = if (passwordVisibilityAgain.value){
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        leadingIcon = { Row{
                            Icon(painter = painterResource(id = R.drawable.off)
                                , contentDescription = "password again", modifier = Modifier.padding(start = 15.dp)
                            )
                            Image(painter = painterResource(id = R.drawable.line), contentDescription = "line", modifier = Modifier.padding(horizontal = 7.dp
                            ))
                        } },
                        trailingIcon = { PasswordVisibilityToggle(isVisible = passwordVisibilityAgain.value, onToggle = {passwordVisibilityAgain.value = it}) },
                        onValueChange = {
                            passwordAgain.value = it
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
                    )
                }
                Column(modifier = Modifier
                    .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                    Text(text = stringResource(id = R.string.signUpPasswordText), color = Color.White ,style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 20.dp), fontWeight = FontWeight.Light)
                    Box(modifier = Modifier.padding(vertical = 30.dp)) {
                        BackNextButtonGroup(navController = navController, backRoute = Screen.SignUpNameScreen.route, nextRoute = Screen.LoginScreen.route)
                    }
                }
            }
        }
    }
}