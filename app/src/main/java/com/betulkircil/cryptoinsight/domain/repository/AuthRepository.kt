package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.utils.Resource
import com.google.firebase.auth.AuthResult

interface AuthRepository {
    suspend fun signInUser(email:String, password:String) : kotlinx.coroutines.flow.Flow<Resource<AuthResult>>
    suspend fun signUpUser(email: String, password: String) : kotlinx.coroutines.flow.Flow<Resource<AuthResult>>
}