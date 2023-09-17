package com.betulkircil.cryptoinsight.domain.useCase.appEntryUseCase

import com.betulkircil.cryptoinsight.domain.manager.LocalUserManager
import javax.inject.Inject

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}