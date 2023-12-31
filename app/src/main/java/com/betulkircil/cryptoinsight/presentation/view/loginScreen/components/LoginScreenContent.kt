package com.betulkircil.cryptoinsight.presentation.view.loginScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.AppBarSection
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PasswordVisibilityToggle
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenContent(navController : NavController, viewModel : LoginViewModel = hiltViewModel()) {
    val coroutineScope = rememberCoroutineScope()
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBarSection(navController, "homeScreen", "loginScreen")
        LinkText(firstText = stringResource(id = R.string.notMemberText), linkText = stringResource(
            id = R.string.createAccountText
        ), navController = navController, route = Screen.SignUpMailScreen.route)
        Column(modifier = Modifier
            , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            var isClicked = remember { mutableStateOf(false) }
            var passwordVisibility = remember { mutableStateOf(false) }
            TextFieldLabel(text = stringResource(id = R.string.email))
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
                placeholder = { Text(text = stringResource(id = R.string.mailPlaceHolder), style = MaterialTheme.typography.bodyMedium, color = Color.Gray) }
            )
            TextFieldLabel(text = stringResource(id = R.string.password))
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
                placeholder = { Text(text = stringResource(id = R.string.yourPasswordText), style = MaterialTheme.typography.bodyMedium, color = Color.Gray) }
            )
            ForgotPasswordText()
        }
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
                        navController.navigate(Screen.CoinScreen.route)
                },
                shape = RoundedCornerShape(40),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(23.dp, 9.dp)
                    .height(50.dp),
                border = BorderStroke(2.dp, colorResource(id = R.color.purple_protest)),
                colors = ButtonDefaults.elevatedButtonColors(containerColor = colorResource(
                    id = R.color.purple_protest
                )
                )
            ) {
                Text(text = stringResource(id = R.string.loginText), color = Color.White, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
            }
        }
    }
}