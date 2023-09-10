package com.betulkircil.cryptoinsight.data.local.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.betulkircil.cryptoinsight.data.local.room.dao.SavedCoinsDao
import com.betulkircil.cryptoinsight.domain.model.Coins
import com.betulkircil.cryptoinsight.utils.Converters

@Database(
    entities = [Coins::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class SavedCoinsDatabase : RoomDatabase(){
    abstract fun getSavedCoinsDao() : SavedCoinsDao

    companion object{
        @Volatile
        private var instance : SavedCoinsDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                SavedCoinsDatabase::class.java,
                "favoriteConinsDb.db"
            ).build()
    }
}