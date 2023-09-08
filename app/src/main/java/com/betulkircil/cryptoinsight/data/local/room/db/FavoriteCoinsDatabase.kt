package com.betulkircil.cryptoinsight.data.local.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.betulkircil.cryptoinsight.data.local.room.dao.FavoriteCoinsDao
import com.betulkircil.cryptoinsight.data.local.room.dao.FavoriteNewsDao
import com.betulkircil.cryptoinsight.domain.model.Coins
import com.betulkircil.cryptoinsight.domain.model.NewsModel
import com.betulkircil.cryptoinsight.utils.Converters

@Database(
    entities = [Coins::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class FavoriteCoinsDatabase : RoomDatabase(){
    abstract fun getFavoriteCoinsDao() : FavoriteCoinsDao

    companion object{
        @Volatile
        private var instance : FavoriteCoinsDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FavoriteCoinsDatabase::class.java,
                "favoriteConinsDb.db"
            ).build()
    }
}