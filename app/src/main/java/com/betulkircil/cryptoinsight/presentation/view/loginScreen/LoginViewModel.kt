package com.betulkircil.cryptoinsight.presentation.view.loginScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.cryptoinsight.domain.useCase.signIn.SignInUserUseCase
import com.betulkircil.cryptoinsight.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInUserUseCase: SignInUserUseCase
) : ViewModel(){
    val _loginState = Channel<LoginState>()
    val loginState = _loginState.receiveAsFlow()

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        signInUserUseCase.signInUser(email, password).collect{ result ->
            when(result){
                is Resource.Success -> {
                    _loginState.send(LoginState(isSuccess = "Login success"))
                }
                is Resource.Loading -> {
                    _loginState.send(LoginState(isLoading = true))
                }
                is Resource.Error -> {
                    _loginState.send(LoginState(isError = result.message))
                }
            }
        }
    }
}