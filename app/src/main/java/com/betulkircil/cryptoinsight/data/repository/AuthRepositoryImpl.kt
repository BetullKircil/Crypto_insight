package com.betulkircil.cryptoinsight.data.repository

import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.betulkircil.cryptoinsight.domain.repository.AuthStateResponse
import com.betulkircil.cryptoinsight.domain.repository.ReloadUserResponse
import com.betulkircil.cryptoinsight.domain.repository.RevokeAccessResponse
import com.betulkircil.cryptoinsight.domain.repository.SendEmailVerificationResponse
import com.betulkircil.cryptoinsight.domain.repository.SendPasswordResetEmailResponse
import com.betulkircil.cryptoinsight.domain.repository.SignInResponse
import com.betulkircil.cryptoinsight.domain.repository.SignUpResponse
import com.betulkircil.cryptoinsight.utils.Resource
import com.betulkircil.cryptoinsight.utils.Response
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.tasks.await
import java.time.LocalDate
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun firebaseSignUpWithEmailAndPassword(
        email: String,
        password: String
    ) = try {
        firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        Response.Success(true)
    } catch (e: Exception) {
        Response.Failure(e)
    }


    override suspend fun sendEmailVerification() = try {
        firebaseAuth.currentUser?.sendEmailVerification()?.await()
        Response.Success(true)
    } catch (e: Exception) {
        Response.Failure(e)
    }

    override suspend fun firebaseSignInWithEmailAndPassword(
        email: String,
        password: String
    )= try {
        firebaseAuth.signInWithEmailAndPassword(email, password).await()
        Response.Success(true)
    } catch (e: Exception) {
        Response.Failure(e)
    }

    override suspend fun reloadFirebaseUser() = try {
        firebaseAuth.currentUser?.reload()?.await()
        Response.Success(true)
    } catch (e: Exception) {
        Response.Failure(e)
    }

    override suspend fun sendPasswordResetEmail(email: String) = try {
        firebaseAuth.sendPasswordResetEmail(email).await()
        Response.Success(true)
    } catch (e: Exception) {
        Response.Failure(e)
    }

    override fun signOut() = firebaseAuth.signOut()

    override suspend fun revokeAccess() = try {
        firebaseAuth.currentUser?.delete()?.await()
        Response.Success(true)
    } catch (e: Exception) {
        Response.Failure(e)
    }

    override fun getAuthState(viewModelScope: CoroutineScope) = callbackFlow {
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        firebaseAuth.addAuthStateListener(authStateListener)
        awaitClose {
            firebaseAuth.removeAuthStateListener(authStateListener)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), firebaseAuth.currentUser == null)

    /*override suspend fun signInUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val signInResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(Resource.Success(signInResult))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun signUpUser(
        email: String,
        password: String,
    ): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val signUpResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            emit(Resource.Success(signUpResult))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
    }*/
}