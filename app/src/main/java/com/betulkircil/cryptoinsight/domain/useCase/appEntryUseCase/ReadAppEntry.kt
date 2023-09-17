package com.betulkircil.cryptoinsight.domain.useCase.appEntryUseCase

import com.betulkircil.cryptoinsight.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() : Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}