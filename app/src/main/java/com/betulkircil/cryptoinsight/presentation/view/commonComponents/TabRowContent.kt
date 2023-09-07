package com.betulkircil.cryptoinsight.presentation.view.commonComponents

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.cryptoinsight.R

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun TabRowContent(firstTab: String, secondTab:String, navController: NavController, tabs: List<String>, tabIndex: MutableIntState, firstScreen: @Composable () -> Unit, secondScreen: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.grey_black))
    ) {
        TabRow(
            modifier = Modifier
                .background(color = colorResource(id = R.color.purple_protest))
                .height(60.dp),
            selectedTabIndex = tabIndex.value,
            backgroundColor = colorResource(id = R.color.grey_black),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[tabIndex.value])
                        .fillMaxWidth()
                        .height(1.dp),
                    color = colorResource(id = R.color.purple_protest)
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex.value == index,
                    onClick = { tabIndex.value = index }
                ) {
                    Text(text = title, style = MaterialTheme.typography.titleMedium, color = Color.White)
                }
            }
        }

        when (tabs[tabIndex.value]) {
            firstTab -> firstScreen()
            secondTab -> secondScreen()
        }
    }
}