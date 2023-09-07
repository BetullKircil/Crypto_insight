package com.betulkircil.cryptoinsight.utils

import androidx.room.TypeConverter
import com.betulkircil.cryptoinsight.data.remote.dto.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source) : String{
        return  source.name
    }

    @TypeConverter
    fun toSource(name:String) : Source{
        return Source(name, name)
    }
}