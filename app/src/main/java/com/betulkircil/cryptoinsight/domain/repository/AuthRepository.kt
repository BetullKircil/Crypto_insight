package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.utils.Resource
import com.betulkircil.cryptoinsight.utils.Response
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val currentUser : FirebaseUser?
    suspend fun login(email: String, password: String, name: String? = null) : Response<FirebaseUser>
    suspend fun register(email: String, password: String, name : String? = null) : Response<FirebaseUser>
    fun logout()

    fun googleSignIn(credential: AuthCredential): Flow<Resource<AuthResult>>
}