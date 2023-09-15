package com.betulkircil.cryptoinsight.domain.useCase.appEntryUseCase

import com.betulkircil.cryptoinsight.domain.manager.LocalUserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManager: LocalUserManager
) {
    suspend fun invoke(){
        localUserManager.saveAppEntry()
    }
}