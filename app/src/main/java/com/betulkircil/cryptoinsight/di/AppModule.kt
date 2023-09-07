package com.betulkircil.cryptoinsight.di


import android.content.Context
import com.betulkircil.cryptoinsight.data.local.room.dao.FavoriteNewsDao
import com.betulkircil.cryptoinsight.data.local.room.db.FavoriteNewsDatabase
import com.betulkircil.cryptoinsight.data.repository.CoinRepositoryImpl
import com.betulkircil.cryptoinsight.data.remote.CoinsApi
import com.betulkircil.cryptoinsight.data.remote.ExchangesApi
import com.betulkircil.cryptoinsight.data.remote.NewsApi
import com.betulkircil.cryptoinsight.data.repository.ExchangesRepositoryImpl
import com.betulkircil.cryptoinsight.data.repository.NewsRepositoryImpl
import com.betulkircil.cryptoinsight.data.repository.UserRespositoryImpl
import com.betulkircil.cryptoinsight.domain.repository.CoinRepository
import com.betulkircil.cryptoinsight.domain.repository.AuthRepository
import com.betulkircil.cryptoinsight.domain.repository.AuthRepositoryImpl
import com.betulkircil.cryptoinsight.domain.repository.ExchangesRepository
import com.betulkircil.cryptoinsight.domain.repository.NewsRepository
import com.betulkircil.cryptoinsight.domain.repository.UserRepository
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
    fun provideCoinRepository(api : CoinsApi) : CoinRepository{
        return CoinRepositoryImpl(api)
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
    fun provideNewsRepository(api : NewsApi, newsDb: FavoriteNewsDatabase) : NewsRepository{
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
    fun provideuserRepository(firestore: FirebaseFirestore) :  UserRepository{
        return UserRespositoryImpl(firestore)
    }

    @Provides
    @Singleton
    fun provideExchangesApi(): ExchangesApi {
        return Retrofit.Builder()
            .baseUrl(NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExchangesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideExchangesRepository(exchangesApi: ExchangesApi) :  ExchangesRepository{
        return ExchangesRepositoryImpl(exchangesApi)
    }

    @Provides
    @Singleton
    fun provideFavoriteNewsDatabase(@ApplicationContext context: Context): FavoriteNewsDatabase {
        return FavoriteNewsDatabase(context)
    }

    @Provides
    @Singleton
    fun provideFavoriteNewsDao(database: FavoriteNewsDatabase): FavoriteNewsDao {
        return database.getFavoriteNewsDao()
    }
}