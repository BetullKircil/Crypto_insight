package com.betulkircil.cryptoinsight.domain.useCase.signUp

import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.betulkircil.cryptoinsight.utils.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignUpUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    fun signUpUser(email: String, password: String) : Flow<Resource<AuthResult>> {
        return flow {
           // authRepository.signUpUser(email, password)
        }
    }
}