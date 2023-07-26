package com.betulkircil.cryptoinsight.presentation.view.loginScreen.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.betulkircil.cryptoinsight.presentation.ProgressBar
import com.betulkircil.cryptoinsight.presentation.view.loginScreen.LoginViewModel
import com.betulkircil.cryptoinsight.utils.Resource
import com.betulkircil.cryptoinsight.utils.Response
import com.google.android.play.core.integrity.e

@Composable
fun LoginState(
    viewModel: LoginViewModel = hiltViewModel(),
    showErrorMessage: (errorMessage: String?) -> Unit
) {
    when(val signInResponse = viewModel.signInResponse.value) {
        is Response.Loading-> ProgressBar()
        is Response.Success -> Unit
        is Response.Failure -> signInResponse.apply {
            LaunchedEffect(e) {
                print(e)
                showErrorMessage(e.message)
            }
        }
    }
}