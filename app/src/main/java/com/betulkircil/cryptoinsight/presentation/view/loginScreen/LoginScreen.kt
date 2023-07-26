package com.betulkircil.cryptoinsight.presentation.view.loginScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.view.homeScreen.components.ButtonWithBorder
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.AppBarSection
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.BackgroundImage
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.LinkText
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.LoginButton
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.LogoGroup
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.TextFieldLabel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
    ) {
    val coroutineScope = rememberCoroutineScope()
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Surface(modifier = Modifier.fillMaxSize()) {
            BackgroundImage()
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppBarSection(navController, "homeScreen", "loginScreen")
                LinkText(firstText = "Not a member?", linkText = "Create an Account", navController = navController, route = Screen.SignUpMailScreen.route)
                Column(modifier = Modifier
                    , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                ) {
                    var isClicked = remember { mutableStateOf(false) }
                    var passwordVisibility = remember { mutableStateOf(false)}
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
                        //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
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
                            , contentDescription = "emailIcon", modifier = Modifier.padding(start = 15.dp)
                            )
                            Image(painter = painterResource(id = R.drawable.line), contentDescription = "line", modifier = Modifier.padding(horizontal = 7.dp
                            ))
                        } },
                        trailingIcon = { PasswordVisibilityToggle(isVisible = passwordVisibility.value, onToggle = {passwordVisibility.value = it})},
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
                        placeholder = { Text(text = "Sifreniz", style = MaterialTheme.typography.bodyMedium, color = Color.Gray) }
                    )
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 5.dp), horizontalArrangement = Arrangement.End) {
                        Text(modifier = Modifier.clickable { print("Tiklandi") }, text = "Forgot Password?", color = colorResource(id = R.color.purple_protest), style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold, textAlign = TextAlign.End)
                    }
                }
                //LogoGroup(navController = navController)
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 30.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                    Column(modifier = Modifier) {
                        Image(painter = painterResource(id = R.drawable.sign_up_line), contentDescription = null)
                        Row(modifier = Modifier
                            .padding(20.dp)
                            .align(Alignment.CenterHorizontally), horizontalArrangement = Arrangement.Center) {
                            Image(painter = painterResource(id = R.drawable.google), contentDescription = null, modifier = Modifier.padding(horizontal = 10.dp))
                            Image(painter = painterResource(id = R.drawable.twitter), contentDescription = null, modifier = Modifier.padding(horizontal = 10.dp))
                        }
                    }
                        Button(
                            onClick = {
                                if(email.value.isNotBlank() || password.value.isNotBlank()){
                                    coroutineScope.launch {
                                        //viewModel.loginUser(email.value, password.value)
                                    }
                                    navController.navigate(Screen.HomeScreen.route)
                                }
                            },
                            shape = RoundedCornerShape(40),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(23.dp, 9.dp)
                                .height(50.dp),
                            border = BorderStroke(2.dp, colorResource(id = R.color.purple_protest)),
                            colors = ButtonDefaults.elevatedButtonColors(containerColor = colorResource(
                                id = R.color.purple_protest
                            ))
                        ) {
                            Text(text = "Login", color = Color.White, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                        }
                }
            }
        }
    }
}

@Composable
fun PasswordVisibilityToggle(
    isVisible: Boolean,
    onToggle: (Boolean) -> Unit
) {
    val icon: Painter = if (isVisible) {
        painterResource(id = R.drawable.visibility)
    } else {
        painterResource(id = R.drawable.visibility_off)
    }

    IconButton(
        onClick = { onToggle(!isVisible) },
        modifier = Modifier.padding(4.dp)
    ) {
        Icon(icon, contentDescription = "Toggle password visibility")
    }
}