package com.betulkircil.cryptoinsight.presentation.view.loginScreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.betulkircil.cryptoinsight.utils.Response
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository : AuthRepository
) : ViewModel(){
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
}