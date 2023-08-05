package com.betulkircil.cryptoinsight.di

import com.betulkircil.cryptoinsight.data.repository.CoinRepositoryImpl
import com.betulkircil.cryptoinsight.data.remote.CoinsApi
import com.betulkircil.cryptoinsight.data.repository.AuthRepositoryImpl
import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.betulkircil.cryptoinsight.domain.repository.CoinRepository
import com.betulkircil.cryptoinsight.utils.Constants.COIN_BASE_URL
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFireBaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepositoryImpl(firebaseAuth: FirebaseAuth) : AuthRepository{
        return AuthRepositoryImpl(firebaseAuth)
    }

    /*@Provides
    @Singleton
    fun provideAuthRepository(firebaseAuth: FirebaseAuth) : AuthRepository{
        return AuthRepositoryImpl(firebaseAuth = firebaseAuth)
    }*/

    @Provides
    @Singleton
    fun provideCoinsApi() : CoinsApi{
        return Retrofit.Builder()
            .baseUrl(COIN_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api : CoinsApi) : CoinRepository{
        return CoinRepositoryImpl(api)
    }

}