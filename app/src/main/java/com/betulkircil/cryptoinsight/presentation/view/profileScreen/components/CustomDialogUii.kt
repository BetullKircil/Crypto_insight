package com.betulkircil.cryptoinsight.presentation.view.profileScreen.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginViewModel

@Composable
fun CustomDialogUI(modifier: Modifier = Modifier, openDialogCustom: MutableState<Boolean>, loginViewModel: LoginViewModel, navController: NavController){
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(350.dp),
        contentAlignment = Alignment.Center) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(horizontal = 20.dp),
            elevation = 8.dp
        ) {
            Column(
                modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pp_logout),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(
                        color = colorResource(id = R.color.purple_protest)
                    ),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .height(70.dp)
                        .fillMaxWidth(),

                    )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Warning",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Are you sure you would like to log out?",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                            .fillMaxWidth(),
                        style = androidx.compose.material.MaterialTheme.typography.body2
                    )
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .background(color = colorResource(id = R.color.light_purple)),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    TextButton(onClick = {
                        openDialogCustom.value = false
                    }) {
                        Text(
                            "YES",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.grey_black),
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 5.dp)
                                .clickable {
                                    loginViewModel.logout()
                                    Toast
                                        .makeText(
                                            context,
                                            "Logged out successfully!",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                    navController.navigate("loginScreen") {
                                        popUpTo("profileScreen") { inclusive = true }
                                    }
                                }
                        )
                    }
                    TextButton(onClick = {
                        openDialogCustom.value = false
                    }) {
                        Text(
                            "CANSEL",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.grey_black),
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 5.dp)
                                .clickable {
                                    Toast
                                        .makeText(
                                            context,
                                            "Log out is cancelled!",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                    openDialogCustom.value = false
                                }
                        )
                    }
                }
            }
        }
    }
}
