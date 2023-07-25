package com.betulkircil.cryptoinsight.presentation.view.signUpScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.cryptoinsight.domain.useCase.signUp.SignUpUserUseCase
import com.betulkircil.cryptoinsight.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUserUseCase: SignUpUserUseCase
): ViewModel() {
    val _signUpState = Channel<SignUpState>()
    val signUpState = _signUpState.receiveAsFlow()

    fun signUpUser(email: String, password: String) = viewModelScope.launch {
        signUpUserUseCase.signUpUser(email, password).collect{ result ->
            when(result){
                is Resource.Loading -> {
                    _signUpState.send(SignUpState(isLoading = true))
                }
                is Resource.Success -> {
                    _signUpState.send(SignUpState(isSuccess = "Login success"))

                }
                is Resource.Error -> {
                    _signUpState.send(SignUpState(isError = result.message))
                }
            }
        }
    }
}