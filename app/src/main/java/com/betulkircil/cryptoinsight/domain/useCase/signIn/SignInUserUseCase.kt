package com.betulkircil.cryptoinsight.domain.useCase.signIn

import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.betulkircil.cryptoinsight.utils.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignInUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    fun signInUser(email: String, password: String) : Flow<Resource<AuthResult>>{
        return flow {
           // authRepository.signInUser(email, password)
        }
    }
}