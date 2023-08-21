package com.betulkircil.cryptoinsight.presentation.view.loginScreen

data class LoginState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
