package com.betulkircil.cryptoinsight.presentation.view.commonComponents

import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.Screen

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.grey_black),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        /*BottomNavigationItem(
            icon = {
                IconButton(onClick = {
                    navController.navigate(Screen.CoinScreen.route)}) {
                    Image(painter = painterResource(id = R.drawable.home_not_clicked), contentDescription = null, modifier = Modifier.size(20.dp))
                }
            },
            selected = true,
            onClick = { /*todo*/ },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = {
                IconButton(onClick = { navController.navigate(Screen.MarketPlaceAndNewsSearchScreen.route)}) {
                    Image(painter = painterResource(R.drawable.news_not_clicked), contentDescription = null, modifier = Modifier.size(20.dp))
                }            },
            selected = false,
            onClick = { navController.navigate(Screen.MarketPlaceAndNewsSearchScreen.route) },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = {
                IconButton(onClick = { navController.navigate(Screen.CategoryScreen.route) }) {
                    Image(painter = painterResource(R.drawable.search_not_clicked), contentDescription = null, modifier = Modifier.size(20.dp))
                }
            },
            selected = true,
            onClick = { /*TODO*/ },
        )
        BottomNavigationItem(
            icon = {
                IconButton(onClick = {  }) {
                    Image(painter = painterResource(R.drawable.saved_not_clicked), contentDescription = null, modifier = Modifier.size(20.dp))
                }            },
            selected = true,
            onClick = { /*TODO*/ },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = {
                IconButton(onClick = { navController.navigate(Screen.ProfileScreen.route) }) {
                    Image(painter = painterResource(R.drawable.profile_not_clicekd), contentDescription = null, modifier = Modifier.size(20.dp))
                }            },
            selected = true,
            onClick = { /*TODO*/ },
            alwaysShowLabel = false
        )*/
        ToggleableIcons(navController = navController)
    }
}


@Composable
fun ToggleableIcons(navController: NavController) {
        var selectedIcon = remember { mutableStateOf(IconType.Home) }

    Row(
        modifier = Modifier
            .padding(horizontal = 5.dp).padding(top = 17.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.size(23.dp)) {
            IconToggleButton(
                iconType = IconType.Home,
                selectedIcon = selectedIcon.value,
                onIconClick = { selectedIcon.value = it
                    navController.navigate(Screen.CoinScreen.route)
                },
            )
        }
        Box(modifier = Modifier.size(23.dp)) {
        IconToggleButton(
            iconType = IconType.News,
            selectedIcon = selectedIcon.value,
            onIconClick = { selectedIcon.value = it
                navController.navigate(Screen.MarketPlaceAndNewsSearchScreen.route)
            }
            )
        }

        Box(modifier = Modifier.size(23.dp)) {
            IconToggleButton(
                iconType = IconType.Search,
                selectedIcon = selectedIcon.value,
                onIconClick = { selectedIcon.value = it
                    navController.navigate(Screen.CategoryScreen.route)
                }
            )
        }
        Box(modifier = Modifier.size(23.dp)) {
            IconToggleButton(
                iconType = IconType.Saved,
                selectedIcon = selectedIcon.value,
                onIconClick = { selectedIcon.value = it }
            )
        }
        Box(modifier = Modifier.size(23.dp)) {
            IconToggleButton(
                iconType = IconType.Profile,
                selectedIcon = selectedIcon.value,
                onIconClick = { selectedIcon.value = it
                    navController.navigate(Screen.ProfileScreen.route)
                }
            )
        }
    }
}

@Composable
fun IconToggleButton(
    iconType: IconType,
    selectedIcon: IconType,
    onIconClick: (IconType) -> Unit
) {
    val iconResource: Int = if (iconType == selectedIcon) {
        iconType.selectedResource
    } else {
        iconType.unselectedResource
    }

    IconButton(
        onClick = { onIconClick(iconType) }
    ) {
        IconImage(iconResource)
    }
}

@Composable
fun IconImage(@DrawableRes iconResource: Int) {
    val painter: Painter = painterResource(id = iconResource)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier.size(48.dp)
    )
}

enum class IconType(val selectedResource: Int, val unselectedResource: Int) {
    Home(R.drawable.home_clicked, R.drawable.home_not_clicked),
    News(R.drawable.news_clicked, R.drawable.news_not_clicked),
    Search(R.drawable.search_clicked, R.drawable.search_not_clicked),
    Saved(R.drawable.saved_clicked, R.drawable.saved_not_clicked),
    Profile(R.drawable.profile_clicked, R.drawable.profile_not_clicekd)
}
