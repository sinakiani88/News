package com.example.news.data.cash

import androidx.room.TypeConverter
import com.example.news.data.entities.Source
import org.bouncycastle.util.test.FixedSecureRandom



class Converter {     //دیتابیس افلاین
    @TypeConverter
    fun fromSource (source:Source):String=source.name

    @TypeConverter
    fun toSource (name: String):Source=Source(name,name)
}