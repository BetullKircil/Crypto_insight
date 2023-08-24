package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.utils.Resource
import com.betulkircil.cryptoinsight.utils.Response
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

typealias SignUpResponse = Response<Boolean>
typealias SendEmailVerificationResponse = Response<Boolean>
typealias SignInResponse = Response<Boolean>
typealias ReloadUserResponse = Response<Boolean>
typealias SendPasswordResetEmailResponse = Response<Boolean>
typealias RevokeAccessResponse = Response<Boolean>
typealias AuthStateResponse = StateFlow<Boolean>
interface AuthRepository {
    /*fun loginUser(email: String, password: String) : Flow<Resource<AuthResult>>
    fun registerUser(email:String, password: String) : Flow<Resource<AuthResult>>
    fun googleSignIn(credential: AuthCredential): Flow<Resource<AuthResult>>
    val currentUser: FirebaseUser?

    suspend fun sendPasswordResetEmail(email: String): SendPasswordResetEmailResponse

    fun signOut()
    fun getAuthState(viewModelScope: CoroutineScope): AuthStateResponse*/
    val currentUser : FirebaseUser?
    suspend fun login(email: String, password: String) : Response<FirebaseUser>
    suspend fun register(email: String, password: String) : Response<FirebaseUser>
    fun logout()

}