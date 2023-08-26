package com.betulkircil.cryptoinsight.data.repository

import android.util.Log
import com.betulkircil.cryptoinsight.domain.model.UserProfile
import com.betulkircil.cryptoinsight.domain.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRespositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : UserRepository{
    override suspend fun saveUserProfile(userProfile: UserProfile) {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        if (userId != null) {
            firestore.collection("users").document(userId).set(userProfile)
                .addOnSuccessListener {
                    Log.d("UserRepository", "User profile saved successfully")
                }
                .addOnFailureListener { e ->
                    Log.e("UserRepository", "Error saving user profile: $e")
                }
        }
    }

    override suspend fun getUserProfile(): UserProfile? {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        if (userId != null) {
            val snapshot = firestore.collection("users").document(userId).get().await()
            return snapshot.toObject(UserProfile::class.java)
        }
        return null
    }
}
