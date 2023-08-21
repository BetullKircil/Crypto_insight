package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpMail

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BackgroundImage
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PasswordVisibilityToggle
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.TextFieldLabel
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpViewModel
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.ButtonWithIcon
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.SignUpLinkText
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.SignUpText
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpMailScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val state = viewModel.signUpState.collectAsState(initial = null)
    val email = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    val isClicked = remember { mutableStateOf(false) }
    val password = remember {
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
                //SignUpMailScreenContent()


                Column(modifier = Modifier
                    .padding(vertical = 20.dp)
                    .padding(top = 25.dp)
                    , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                ) {

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

                    val passwordAgain = remember {
                        mutableStateOf("")
                    }
                    Column(modifier = Modifier
                        .padding(vertical = 20.dp)
                        .padding(top = 25.dp)
                        , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                    ) {
                        val isClicked = remember { mutableStateOf(false) }
                        val passwordVisibility = remember { mutableStateOf(false) }
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
                    }



                    /* TextFieldLabel(text = stringResource(id = R.string.telephoneNumber))
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
                             Text(text = stringResource(id = R.string.numberPlaceHolder), style = MaterialTheme.typography.bodyMedium, color = Color.Gray, modifier = Modifier
                                 .padding(horizontal = 5.dp)
                                 .padding(top = 2.dp)) }
                     )*/
                }
                //LogoGroupSignUp(navController = navController)
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 25.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                    Column(modifier = Modifier) {
                        Image(painter = painterResource(id = R.drawable.sign_up_line), contentDescription = null)
                        Row(modifier = Modifier
                            .padding(20.dp)
                            .align(Alignment.CenterHorizontally), horizontalArrangement = Arrangement.Center) {
                            Image(painter = painterResource(id = R.drawable.google), contentDescription = null, modifier = Modifier.padding(horizontal = 10.dp))
                            Image(painter = painterResource(id = R.drawable.twitter), contentDescription = null, modifier = Modifier.padding(horizontal = 10.dp))
                        }
                    }
                    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                        SignUpLinkText(firstText = stringResource(id = R.string.alreadyMemberText), linkText = stringResource(id = R.string.signInText), navController = navController, route = Screen.LoginScreen.route)
                        //ButtonWithIcon(route = Screen.SignUpNameScreen.route, navController = navController, buttonText = stringResource(id = R.string.nextButtonText), width = 500)

                        Box(modifier = Modifier){
                            Button(
                                onClick = {
                                    scope.launch {
                                        viewModel.registerUser(email.value, password.value)
                                        Log.d("dşdhfclsfd", "ışhfcıosdh")
                                    }
                                    navController.navigate(Screen.SignUpNameScreen.route)
                                },
                                shape = RoundedCornerShape(40),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp, 0.dp).padding(bottom = 2.dp)
                                    .height(50.dp),
                                border = BorderStroke(2.dp, colorResource(id = R.color.purple_protest)),
                                colors = ButtonDefaults.elevatedButtonColors(containerColor = colorResource(
                                    id = R.color.purple_protest
                                ))
                            ) {
                                Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                                    Text(text = "Next", color = Color.White, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                                    Image(painter = painterResource(id = R.drawable.arrow_right), contentDescription = null, modifier = Modifier.padding(horizontal = 5.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    LaunchedEffect(key1 = state.value?.isSuccess) {
        scope.launch {
            if (state.value?.isSuccess?.isNotEmpty() == true) {
                val success = state.value?.isSuccess
                Toast.makeText(context, "$success", Toast.LENGTH_LONG).show()
            }
        }
    }
    LaunchedEffect(key1 = state.value?.isError) {
        scope.launch {
            if (state.value?.isError?.isNotBlank() == true) {
                val error = state.value?.isError
                Toast.makeText(context, "$error", Toast.LENGTH_LONG).show()
            }
        }
    }
}