package com.betulkircil.cryptoinsight.presentation.view.loginScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.betulkircil.cryptoinsight.domain.repository.SignInResponse
import com.betulkircil.cryptoinsight.domain.useCase.signIn.SignInUserUseCase
import com.betulkircil.cryptoinsight.utils.Resource
import com.betulkircil.cryptoinsight.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel(){
    var signInResponse =  mutableStateOf<SignInResponse>(Response.Success(false))
        private set

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        signInResponse.value = Response.Loading
        signInResponse.value = repository.firebaseSignInWithEmailAndPassword(email, password)
    }







    /*val _loginState = Channel<LoginState>()
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
    }*/
}