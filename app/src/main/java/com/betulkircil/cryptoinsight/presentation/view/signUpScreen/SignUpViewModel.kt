package com.betulkircil.cryptoinsight.presentation.view.signUpScreen


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
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {

    private val _registerFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val registerFlow : StateFlow<Response<FirebaseUser>?> = _registerFlow

    fun register(email: String, password: String) = viewModelScope.launch {
        _registerFlow.value = Response.Loading
        val result = repository.register(email, password)
        _registerFlow.value= result
    }
    val currentUser : FirebaseUser?
        get() = repository.currentUser
    init {
        if(repository.currentUser != null){
            _registerFlow.value = Response.Success(repository.currentUser!!)
        }
    }
}