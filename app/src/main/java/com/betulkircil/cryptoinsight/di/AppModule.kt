package com.betulkircil.cryptoinsight.di


import android.content.Context
import com.betulkircil.cryptoinsight.data.local.room.dao.SavedCoinsDao
import com.betulkircil.cryptoinsight.data.local.room.dao.SavedNewsDao
import com.betulkircil.cryptoinsight.data.local.room.db.SavedCoinsDatabase
import com.betulkircil.cryptoinsight.data.local.room.db.SavedNewsDatabase
import com.betulkircil.cryptoinsight.data.manager.LocalUserManagerImpl
import com.betulkircil.cryptoinsight.data.repository.CoinRepositoryImpl
import com.betulkircil.cryptoinsight.data.remote.CoinsApi
import com.betulkircil.cryptoinsight.data.remote.NewsApi
import com.betulkircil.cryptoinsight.data.repository.NewsRepositoryImpl
import com.betulkircil.cryptoinsight.domain.manager.LocalUserManager
import com.betulkircil.cryptoinsight.domain.repository.CoinRepository
import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.betulkircil.cryptoinsight.domain.repository.AuthRepositoryImpl
import com.betulkircil.cryptoinsight.domain.repository.NewsRepository
import com.betulkircil.cryptoinsight.utils.Constants.COIN_BASE_URL
import com.betulkircil.cryptoinsight.utils.Constants.NEWS_BASE_URL
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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
    fun provideCoinRepository(api : CoinsApi, coinsDb: SavedCoinsDatabase) : CoinRepository{
        return CoinRepositoryImpl(api, coinsDb)
    }

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(api : NewsApi, newsDb: SavedNewsDatabase) : NewsRepository{
        return NewsRepositoryImpl(api, newsDb)
    }

    @Provides
    @Singleton
    fun provideFirebase() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideRepositoryImpl(firebaseAuth: FirebaseAuth) :AuthRepository{
        return AuthRepositoryImpl(firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore {
        val settings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(true)
            .build()

        val firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = settings

        return firestore
    }
    @Provides
    @Singleton
    fun provideSavedNewsDatabase(@ApplicationContext context: Context): SavedNewsDatabase {
        return SavedNewsDatabase(context)
    }

    @Provides
    @Singleton
    fun provideSavedNewsDao(database: SavedNewsDatabase): SavedNewsDao {
        return database.getSavedNewsDao()
    }
    @Provides
    @Singleton
    fun provideSavedCoinsDatabase(@ApplicationContext context: Context): SavedCoinsDatabase {
        return SavedCoinsDatabase(context)
    }

    @Provides
    @Singleton
    fun provideSavedCoinsDao(database: SavedCoinsDatabase): SavedCoinsDao {
        return database.getSavedCoinsDao()
    }

    @Provides
    @Singleton
    fun provideLocalUserManager(context: Context) : LocalUserManager{
        return LocalUserManagerImpl(context = context)
    }
}