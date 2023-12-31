package com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpMail

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginViewModel
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.TextFieldLabel
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.SignUpViewModel
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.SignUpLinkText
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.components.SignUpText
import com.betulkircil.cryptoinsight.presentation.view.signUpScreen.signUpPassword.components.SignUpPasswordText
import com.betulkircil.cryptoinsight.utils.Constants
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpMailScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel(),
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val specialCharacters = "!@#\$%^&*()_+[]{}|;:'\",.<>?`~"
    val signUpFlow = viewModel?.registerFlow?.collectAsState()

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val email = remember { mutableStateOf("") }
    val isClicked = remember { mutableStateOf(false) }
    val password = remember {
        mutableStateOf("")
    }
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            val account = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val result = account.getResult(ApiException::class.java)
                val credentials = GoogleAuthProvider.getCredential(result.idToken, null)
                loginViewModel.googleSignIn(credentials)

                navController.navigate(Screen.CoinScreen.route)
            } catch (ex: ApiException) {
                Toast.makeText(context, "Sign In Success", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.CoinScreen.route)
            }
        }

    Scaffold(
        content = { it
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
                        AppBarSection(navController, "homeScreen", "signUpMailScreen")
                        SignUpText()
                        Column(
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                                .padding(top = 25.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
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
                                leadingIcon = {
                                    Row {
                                        Icon(
                                            imageVector = Icons.Default.Email,
                                            contentDescription = "emailIcon",
                                            modifier = Modifier.padding(start = 15.dp),
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
                                    email.value = it
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
                                placeholder = {
                                    Text(
                                        text = stringResource(id = R.string.mailPlaceHolder),
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color.Gray
                                    )
                                }
                            )

                            Column(
                                modifier = Modifier
                                ,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
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
                                    visualTransformation = if (passwordVisibility.value) {
                                        VisualTransformation.None
                                    } else {
                                        PasswordVisualTransformation()
                                    },
                                    leadingIcon = {
                                        Row {
                                            Icon(
                                                painter = painterResource(id = R.drawable.off),
                                                contentDescription = "password",
                                                modifier = Modifier.padding(start = 15.dp)
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
                                    trailingIcon = {
                                        PasswordVisibilityToggle(
                                            isVisible = passwordVisibility.value,
                                            onToggle = { passwordVisibility.value = it })
                                    },
                                    onValueChange = {
                                        password.value = it
                                        if (it.length >= 7 && it.any { char -> char.isUpperCase() } && it.any { char -> specialCharacters.contains(char) }) {
                                            Toast.makeText(context, "Strong password", Toast.LENGTH_SHORT).show()

                                        }
                                        else{
                                            Toast.makeText(context, "Your password must be a minimum of 8 characters, contain uppercase and special characters", Toast.LENGTH_SHORT).show()
                                        }
                                    },
                                    shape = RoundedCornerShape(22.dp),
                                    colors = TextFieldDefaults.textFieldColors(
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        cursorColor = colorResource(id = R.color.purple_protest),
                                        containerColor = Color.White
                                    ),
                                    keyboardOptions = KeyboardOptions(
                                        capitalization = KeyboardCapitalization.None,
                                        autoCorrect = true,
                                        imeAction = ImeAction.Next
                                    ),
                                )
                                SignUpPasswordText()
                            }
                             Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(bottom = 25.dp, top = 5.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(modifier = Modifier) {
                                    Image(
                                        painter = painterResource(id = R.drawable.sign_up_line),
                                        contentDescription = null
                                    )
                                    Row(
                                        modifier = Modifier
                                            .padding(20.dp)
                                            .align(Alignment.CenterHorizontally),
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Image(painter = painterResource(id = R.drawable.google),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .padding(horizontal = 10.dp)
                                                .clickable {
                                                    val gso= GoogleSignInOptions.Builder(
                                                    GoogleSignInOptions.DEFAULT_SIGN_IN)
                                                    .requestEmail()
                                                    .requestIdToken(Constants.ServerClient)
                                                    .build()

                                                    val googleSingInClient = GoogleSignIn.getClient(context, gso)

                                                    launcher.launch(googleSingInClient.signInIntent) })
                                    }
                                }
                                Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                                    SignUpLinkText(
                                        firstText = stringResource(id = R.string.alreadyMemberText),
                                        linkText = stringResource(id = R.string.signInText),
                                        navController = navController,
                                        route = Screen.LoginScreen.route
                                    )

                                    Box(modifier = Modifier) {
                                        Button(
                                            onClick = {
                                                if (email.value.isNotBlank() && password.value.isNotBlank() &&
                                                    password.value.length >= 8 &&
                                                    password.value.any { char -> char.isUpperCase() } &&
                                                    password.value.any { char -> specialCharacters.contains(char) }) {
                                                    scope.launch {
                                                        viewModel.register(email.value, password.value)
                                                        Toast.makeText(
                                                            context,
                                                            "Account created succesfully!",
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    }
                                                    navController.navigate(Screen.SignUpNameScreen.route)
                                                } else {
                                                    Toast.makeText(
                                                        context,
                                                        "Account create failed! Please fill all the fields and meet the conditions!",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                }
                                            },
                                            shape = RoundedCornerShape(40),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(20.dp, 0.dp)
                                                .padding(bottom = 2.dp)
                                                .height(50.dp),
                                            border = BorderStroke(
                                                2.dp,
                                                colorResource(id = R.color.purple_protest)
                                            ),
                                            colors = ButtonDefaults.elevatedButtonColors(
                                                containerColor = colorResource(
                                                    id = R.color.purple_protest
                                                )
                                            )
                                        ) {
                                            Row(
                                                modifier = Modifier.fillMaxSize(),
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = "Next",
                                                    color = Color.White,
                                                    style = MaterialTheme.typography.bodyLarge,
                                                    fontWeight = FontWeight.Bold
                                                )
                                                Image(
                                                    painter = painterResource(id = R.drawable.arrow_right),
                                                    contentDescription = null,
                                                    modifier = Modifier.padding(horizontal = 5.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                signUpFlow?.value?.let {
                    when (it) {
                        is com.betulkircil.cryptoinsight.utils.Response.Failure -> {
                            val context = LocalContext.current
                            Toast.makeText(context, it.e.message, Toast.LENGTH_LONG).show()
                        }

                       is com.betulkircil.cryptoinsight.utils.Response.Loading -> {
                            CircularProgressIndicator()
                        }

                        is com.betulkircil.cryptoinsight.utils.Response.Success -> {
                            LaunchedEffect(Unit) {
                                navController.navigate(Screen.ProfileScreen.route) {
                                    popUpTo(Screen.SignUpMailScreen.route) { inclusive = true }
                                }
                            }
                        }
                    }
                }
            }
        },
    )
}
