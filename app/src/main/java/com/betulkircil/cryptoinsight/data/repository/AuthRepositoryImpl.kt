package com.betulkircil.cryptoinsight.data.repository

import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.betulkircil.cryptoinsight.utils.Resource
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import java.time.LocalDate
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override suspend fun signInUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val signInResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(Resource.Success(signInResult))
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
        }.flowOn(Dispatchers.IO)
    }
}