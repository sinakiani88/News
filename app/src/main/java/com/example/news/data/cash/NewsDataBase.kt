package com.example.news.data.cash

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.news.data.entities.Article

//روم ماژول
@Database(entities = [Article::class],version = 1,exportSchema = false)  //دیتابیس افلاین
@TypeConverters(Converter::class)
abstract class NewsDataBase:RoomDatabase() {
    abstract val newsDao:NewsDao
}