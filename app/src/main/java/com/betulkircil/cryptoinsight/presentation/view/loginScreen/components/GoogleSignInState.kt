package com.betulkircil.cryptoinsight.presentation.view.loginScreen.components

data class GoogleSignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)