package com.betulkircil.cryptoinsight.presentation.view.signUpScreen

data class SignUpState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)