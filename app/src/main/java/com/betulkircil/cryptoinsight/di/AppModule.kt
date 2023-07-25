package com.betulkircil.cryptoinsight.di

import com.betulkircil.cryptoinsight.data.repository.AuthRepositoryImpl
import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFireBaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepositoryImpl(firebaseAuth: FirebaseAuth) : AuthRepositoryImpl{
        return AuthRepositoryImpl(firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(firebaseAuth: FirebaseAuth) : AuthRepository{
        return AuthRepositoryImpl(firebaseAuth = firebaseAuth)
    }
}