package com.betulkircil.cryptoinsight.presentation.view.loginScreen


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.betulkircil.cryptoinsight.utils.Resource
import com.betulkircil.cryptoinsight.utils.Response
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository : AuthRepository
    ): ViewModel(){

    private val isLoggedInState = mutableStateOf(false)

    val _googleState = mutableStateOf(GoogleSignInState())
    val googleState: State<GoogleSignInState> = _googleState

    fun isLoggedIn(): State<Boolean> {
        return isLoggedInState
    }

    init {
        if(repository.currentUser?.displayName != null){
            isLoggedInState.value = true
        }
    }
    private val _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow : StateFlow<Response<FirebaseUser>?> = _loginFlow

    private val _registerFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val registerFlow : StateFlow<Response<FirebaseUser>?> = _registerFlow

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginFlow.value = Response.Loading
        val result = repository.login(email, password)
        _loginFlow.value= result
    }

    fun logout(){
        repository.logout()
        _loginFlow.value = null
        _registerFlow.value = null
    }
    val currentUser : FirebaseUser?
        get() = repository.currentUser
    init {
        if(repository.currentUser != null){
            _loginFlow.value = Response.Success(repository.currentUser!!)
        }
    }

    fun googleSignIn(credential: AuthCredential) = viewModelScope.launch {
        repository.googleSignIn(credential).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _googleState.value = GoogleSignInState(success = result.data)
                }
                is Resource.Loading -> {
                    _googleState.value = GoogleSignInState(loading = true)
                }
                is Resource.Error -> {
                    _googleState.value = GoogleSignInState(error = result.message!!)
                }
            }


        }
    }

}