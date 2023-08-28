package com.betulkircil.cryptoinsight.presentation.view.CategoryScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.CategoryScreen.components.LazyVerticalGridDemo
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.BottomNavigationBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.NewsAppBar
import com.betulkircil.cryptoinsight.presentation.view.commonComponents.PageTitle
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.AppBarContent
import com.betulkircil.cryptoinsight.presentation.view.marketPlaceScreen.components.SearchBar

@Composable
fun CategoryScreen(navController : NavController) {
    var searchQuery = remember {
        mutableStateOf("")
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.grey_black)),
        topBar = { NewsAppBar(greetingContent = { AppBarContent("Search", pngRes = R.drawable.search_not_clicked) }) },
        bottomBar = { BottomNavigationBar(navController = navController) },
        content = {
           it
            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.grey_black)), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 10.dp)) {
                    TextField(
                        value = searchQuery.value,
                        onValueChange = {
                            searchQuery.value = it
                        },
                        shape = RoundedCornerShape(12.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done
                        ),
                        maxLines = 1,
                        singleLine = true,
                        textStyle = androidx.compose.material3.MaterialTheme.typography.bodyMedium.copy(
                            color = Color.White
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.White,
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(22.dp),
                                color = colorResource(id = R.color.purple_protest)
                            ),
                        placeholder = {
                            Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                Image(painter = painterResource(id = R.drawable.search_not_clicked), contentDescription = null, modifier = Modifier
                                    .size(30.dp)
                                    .padding(horizontal = 7.dp))
                                androidx.compose.material3.Text(
                                    text = "Search",
                                    color = Color.LightGray,
                                    modifier = Modifier.padding(
                                        horizontal = 10.dp
                                    ),
                                    fontWeight = FontWeight.Light
                                )
                            }
                        }
                    )
                }
                PageTitle(text = "Popular Topics")
                LazyVerticalGridDemo(searchQuery.value)
            }
        }
    )
}