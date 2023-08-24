package com.betulkircil.cryptoinsight.presentation.view.commonComponents

import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
@Composable
fun Snackbar() {
   val scaffoldState : ScaffoldState = rememberScaffoldState()
    val coroutineScope :CoroutineScope = rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState) { it
        Button(onClick = { 
            coroutineScope.launch { 
                scaffoldState.snackbarHostState.showSnackbar(
                    message = "Please fill the all gaps",
                    actionLabel = "OK",
                    duration = SnackbarDuration.Indefinite
                )
            }
        }) {
            Text(text = "SS")
        }
    }
}