package com.betulkircil.cryptoinsight.presentation.view.loginScreen

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen
import com.betulkircil.cryptoinsight.presentation.view.entryScreen.components.ButtonWithBorder
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.AppBarSection
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.BackgroundImage
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.CreateAccountText
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.components.TextFieldLabel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
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
                AppBarSection()
                CreateAccountText()
                Column(modifier = Modifier
                    , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                ) {
                    var email = remember { mutableStateOf("") }
                    var password = remember { mutableStateOf("") }
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
                        ),
                        placeholder = { Text(text = "Sifreniz", style = MaterialTheme.typography.bodyMedium, color = Color.Gray) }
                    )
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 5.dp), horizontalArrangement = Arrangement.End) {
                        Text(modifier = Modifier.clickable { print("Tiklandi") }, text = "Forgot Password?", color = colorResource(id = R.color.purple_protest), style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold, textAlign = TextAlign.End)
                    }
                }
                Column(modifier = Modifier
                    .fillMaxSize().padding(vertical = 30.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                    Column(modifier = Modifier) {
                        Image(painter = painterResource(id = R.drawable.sign_up_line), contentDescription = null)
                        Row(modifier = Modifier
                            .padding(20.dp)
                            .align(Alignment.CenterHorizontally), horizontalArrangement = Arrangement.Center) {
                            Image(painter = painterResource(id = R.drawable.google), contentDescription = null, modifier = Modifier.padding(horizontal = 10.dp))
                            Image(painter = painterResource(id = R.drawable.twitter), contentDescription = null, modifier = Modifier.padding(horizontal = 10.dp))
                        }
                    }
                    ButtonWithBorder(navController = navController, buttonText = "Login", route = Screen.HomeScreen.route)
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