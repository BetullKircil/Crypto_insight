package com.betulkircil.cryptoinsight.presentation.view.profileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.cryptoinsight.domain.model.UserProfile
import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.betulkircil.cryptoinsight.domain.useCase.userProfileUseCase.getUserProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class profileViewModel @Inject constructor(
    private val repository: AuthRepository,
    private val getUserProfileUseCase: getUserProfileUseCase
) : ViewModel(){
    private val _userProfile: MutableStateFlow<UserProfile?> = MutableStateFlow(null)
    val userProfile: StateFlow<UserProfile?> = _userProfile
    init {
        fetchUserProfile()
    }

    /*val userProfile: StateFlow<UserProfile?> = flow {
        val profile = getUserProfileUseCase()
        emit(profile)
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)*/
    fun fetchUserProfile() {
        viewModelScope.launch {
            val profile = getUserProfileUseCase()
            _userProfile.value = profile
        }
    }
}