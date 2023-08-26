package com.betulkircil.cryptoinsight.presentation.view.profileScreen

import androidx.lifecycle.ViewModel
import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class profileViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel(){

}