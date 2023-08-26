package com.betulkircil.cryptoinsight.domain.repository

import com.betulkircil.cryptoinsight.domain.model.UserProfile

interface UserRepository {
    suspend fun saveUserProfile(userProfile: UserProfile)
    suspend fun getUserProfile(): UserProfile?
}