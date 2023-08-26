package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.utils.Response
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    val currentUser : FirebaseUser?
    suspend fun login(email: String, password: String, name: String? = null) : Response<FirebaseUser>
    suspend fun register(email: String, password: String, name : String? = null) : Response<FirebaseUser>
    fun logout()

}