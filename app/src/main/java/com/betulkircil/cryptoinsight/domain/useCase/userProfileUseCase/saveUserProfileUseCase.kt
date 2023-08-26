package com.betulkircil.cryptoinsight.domain.useCase.userProfileUseCase

import com.betulkircil.cryptoinsight.domain.model.UserProfile
import com.betulkircil.cryptoinsight.domain.repository.UserRepository
import javax.inject.Inject

class saveUserProfileUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userProfile: UserProfile) {
        userRepository.saveUserProfile(userProfile)
    }
}