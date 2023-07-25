package com.betulkircil.cryptoinsight.presentation.view.loginScreen

import androidx.lifecycle.ViewModel
import com.betulkircil.cryptoinsight.domain.useCase.signIn.SignInUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInUserUseCase: SignInUserUseCase
) : ViewModel(){
}